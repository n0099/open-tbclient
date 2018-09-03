package com.baidu.tieba.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a gbs;
    private static String gbt;
    public TextView awM;
    public TextView axI;
    public TextView axQ;
    private final LinearLayout fka;
    protected final LinearLayout gbp;
    protected final ColumnLayout gbq;
    protected final ColumnLayout gbr;
    private int gbu;
    public LinearLayout gbv;
    public HeadImageView gbw;
    public TextView gbx;
    private InterfaceC0220a giK;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0220a {
        void bw(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gbv = (LinearLayout) view.findViewById(f.g.top_line);
        this.gbw = (HeadImageView) view.findViewById(f.g.portrait);
        this.axI = (TextView) view.findViewById(f.g.username);
        this.awM = (TextView) view.findViewById(f.g.reply_time);
        this.axQ = (TextView) view.findViewById(f.g.forum_name);
        this.gbx = (TextView) view.findViewById(f.g.reply_count);
        this.fka = (LinearLayout) view.findViewById(f.g.item_content);
        this.gbq = (ColumnLayout) view.findViewById(f.g.item_header);
        this.gbr = (ColumnLayout) view.findViewById(f.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(f.g.person_thread);
        this.gbp = (LinearLayout) view.findViewById(f.g.person_child);
        this.gbu = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fka != null) {
            this.fka.setOnClickListener(this);
        }
        this.gbw.setOnClickListener(this);
        this.axI.setOnClickListener(this);
        this.axQ.setOnClickListener(this);
        this.gbx.setOnClickListener(this);
        this.gbq.setOnClickListener(this);
        this.gbr.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.giK != null) {
            this.giK.bw(view);
        }
    }

    public void a(InterfaceC0220a interfaceC0220a) {
        this.giK = interfaceC0220a;
    }

    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        boolean z2;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String[] strArr = new String[4];
        try {
            if (z) {
                z2 = true;
                str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.post_id);
                str3 = ap.w(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
                strArr[3] = String.valueOf(postInfoList.thread_type);
            } else {
                z2 = true;
                str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                strArr[3] = String.valueOf(postInfoList.thread_type);
                str3 = ap.w(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.axI.setText(str2);
            this.awM.setText(str3);
            this.axQ.setText(str4);
            this.axQ.setTag(str4);
            this.gbx.setText(str5);
            this.axQ.setOnClickListener(this);
            sa(str);
            if (this.fka != null) {
                this.fka.setTag(strArr);
            }
            this.gbq.setTag(strArr);
            this.gbr.setTag(strArr);
        }
    }

    private void sa(String str) {
        if (gbt != null && !gbt.equals(str)) {
            gbs = null;
        }
        if (gbs != null) {
            this.gbw.setImageBitmap(gbs.nb());
            gbt = str;
            return;
        }
        this.gbw.startLoad(str, 12, this.gbu, this.gbu, false);
    }

    public void dB(int i) {
        am.c(this.axQ, f.d.cp_cont_d, 1);
        am.c(this.awM, f.d.cp_cont_d, 1);
        am.c(this.axI, f.d.cp_cont_f, 1);
        am.i(this.mLayout, f.d.cp_bg_line_c);
        am.i(this.gbp, f.C0146f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.gbx.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.c(this.gbx, f.d.cp_link_tip_c, 1);
    }
}
