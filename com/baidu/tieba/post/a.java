package com.baidu.tieba.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a gqg;
    private static String gqh;
    public TextView bdY;
    public TextView bdk;
    public TextView beO;
    public TextView fmI;
    private final LinearLayout fyL;
    protected final LinearLayout gqd;
    protected final ColumnLayout gqe;
    protected final ColumnLayout gqf;
    private int gqi;
    public LinearLayout gqj;
    public HeadImageView gqk;
    private InterfaceC0220a gxb;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0220a {
        void cJ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gqj = (LinearLayout) view.findViewById(d.g.top_line);
        this.gqk = (HeadImageView) view.findViewById(d.g.portrait);
        this.bdY = (TextView) view.findViewById(d.g.username);
        this.bdk = (TextView) view.findViewById(d.g.reply_time);
        this.beO = (TextView) view.findViewById(d.g.forum_name);
        this.fmI = (TextView) view.findViewById(d.g.reply_count);
        this.fyL = (LinearLayout) view.findViewById(d.g.item_content);
        this.gqe = (ColumnLayout) view.findViewById(d.g.item_header);
        this.gqf = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.gqd = (LinearLayout) view.findViewById(d.g.person_child);
        this.gqi = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fyL != null) {
            this.fyL.setOnClickListener(this);
        }
        this.gqk.setOnClickListener(this);
        this.bdY.setOnClickListener(this);
        this.beO.setOnClickListener(this);
        this.fmI.setOnClickListener(this);
        this.gqe.setOnClickListener(this);
        this.gqf.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gxb != null) {
            this.gxb.cJ(view);
        }
    }

    public void a(InterfaceC0220a interfaceC0220a) {
        this.gxb = interfaceC0220a;
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
                str2 = postInfoList.user_name;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.post_id);
                str3 = am.z(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
                strArr[3] = String.valueOf(postInfoList.thread_type);
            } else {
                z2 = true;
                str2 = postInfoList.user_name;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                strArr[3] = String.valueOf(postInfoList.thread_type);
                str3 = am.z(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.bdY.setText(str2);
            this.bdk.setText(str3);
            this.beO.setText(str4);
            this.beO.setTag(str4);
            this.fmI.setText(str5);
            this.beO.setOnClickListener(this);
            fM(str);
            if (this.fyL != null) {
                this.fyL.setTag(strArr);
            }
            this.gqe.setTag(strArr);
            this.gqf.setTag(strArr);
        }
    }

    private void fM(String str) {
        if (gqh != null && !gqh.equals(str)) {
            gqg = null;
        }
        if (gqg != null) {
            this.gqk.setImageBitmap(gqg.sh());
            gqh = str;
            return;
        }
        this.gqk.startLoad(str, 12, this.gqi, this.gqi, false);
    }

    public void gx(int i) {
        aj.e(this.beO, d.C0140d.cp_cont_d, 1);
        aj.e(this.bdk, d.C0140d.cp_cont_d, 1);
        aj.e(this.bdY, d.C0140d.cp_cont_f, 1);
        aj.s(this.mLayout, d.C0140d.cp_bg_line_c);
        aj.s(this.gqd, d.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.fmI.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.e(this.fmI, d.C0140d.cp_link_tip_c, 1);
    }
}
