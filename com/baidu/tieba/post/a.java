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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a grK;
    private static String grL;
    public TextView aFx;
    public TextView aGP;
    public TextView aGk;
    public HeadImageView dUm;
    private final LinearLayout fAz;
    protected final LinearLayout grH;
    protected final ColumnLayout grI;
    protected final ColumnLayout grJ;
    private int grM;
    public LinearLayout grN;
    public TextView grO;
    private InterfaceC0288a gzf;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0288a {
        void bL(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.grN = (LinearLayout) view.findViewById(e.g.top_line);
        this.dUm = (HeadImageView) view.findViewById(e.g.portrait);
        this.aGP = (TextView) view.findViewById(e.g.username);
        this.aFx = (TextView) view.findViewById(e.g.reply_time);
        this.aGk = (TextView) view.findViewById(e.g.forum_name);
        this.grO = (TextView) view.findViewById(e.g.reply_count);
        this.fAz = (LinearLayout) view.findViewById(e.g.item_content);
        this.grI = (ColumnLayout) view.findViewById(e.g.item_header);
        this.grJ = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(e.g.person_thread);
        this.grH = (LinearLayout) view.findViewById(e.g.person_child);
        this.grM = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fAz != null) {
            this.fAz.setOnClickListener(this);
        }
        this.dUm.setOnClickListener(this);
        this.aGP.setOnClickListener(this);
        this.aGk.setOnClickListener(this);
        this.grO.setOnClickListener(this);
        this.grI.setOnClickListener(this);
        this.grJ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gzf != null) {
            this.gzf.bL(view);
        }
    }

    public void a(InterfaceC0288a interfaceC0288a) {
        this.gzf = interfaceC0288a;
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
                str3 = ao.E(postInfoList.create_time * 1000);
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
                str3 = ao.E(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.aGP.setText(str2);
            this.aFx.setText(str3);
            this.aGk.setText(str4);
            this.aGk.setTag(str4);
            this.grO.setText(str5);
            this.aGk.setOnClickListener(this);
            tm(str);
            if (this.fAz != null) {
                this.fAz.setTag(strArr);
            }
            this.grI.setTag(strArr);
            this.grJ.setTag(strArr);
        }
    }

    private void tm(String str) {
        if (grL != null && !grL.equals(str)) {
            grK = null;
        }
        if (grK != null) {
            this.dUm.setImageBitmap(grK.oq());
            grL = str;
            return;
        }
        this.dUm.startLoad(str, 12, this.grM, this.grM, false);
    }

    public void ek(int i) {
        al.c(this.aGk, e.d.cp_cont_d, 1);
        al.c(this.aFx, e.d.cp_cont_d, 1);
        al.c(this.aGP, e.d.cp_cont_f, 1);
        al.i(this.mLayout, e.d.cp_bg_line_c);
        al.i(this.grH, e.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.grO.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.grO, e.d.cp_link_tip_c, 1);
    }
}
