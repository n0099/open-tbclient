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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a fLP;
    private static String fLQ;
    public TextView aos;
    public TextView apV;
    public TextView apg;
    public TextView eIu;
    private final LinearLayout eUE;
    protected final LinearLayout fLM;
    protected final ColumnLayout fLN;
    protected final ColumnLayout fLO;
    private int fLR;
    public LinearLayout fLS;
    public HeadImageView fLT;
    private InterfaceC0203a fSV;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0203a {
        void bp(View view2);
    }

    public a(View view2, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fLS = (LinearLayout) view2.findViewById(d.g.top_line);
        this.fLT = (HeadImageView) view2.findViewById(d.g.portrait);
        this.apg = (TextView) view2.findViewById(d.g.username);
        this.aos = (TextView) view2.findViewById(d.g.reply_time);
        this.apV = (TextView) view2.findViewById(d.g.forum_name);
        this.eIu = (TextView) view2.findViewById(d.g.reply_count);
        this.eUE = (LinearLayout) view2.findViewById(d.g.item_content);
        this.fLN = (ColumnLayout) view2.findViewById(d.g.item_header);
        this.fLO = (ColumnLayout) view2.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view2.findViewById(d.g.person_thread);
        this.fLM = (LinearLayout) view2.findViewById(d.g.person_child);
        this.fLR = com.baidu.adp.lib.util.l.dip2px(view2.getContext(), 42.0f);
        if (this.eUE != null) {
            this.eUE.setOnClickListener(this);
        }
        this.fLT.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.apV.setOnClickListener(this);
        this.eIu.setOnClickListener(this);
        this.fLN.setOnClickListener(this);
        this.fLO.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view2.getTag(), "")));
            }
        } else if (this.fSV != null) {
            this.fSV.bp(view2);
        }
    }

    public void a(InterfaceC0203a interfaceC0203a) {
        this.fSV = interfaceC0203a;
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
                str3 = an.s(postInfoList.create_time * 1000);
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
                str3 = an.s(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.apg.setText(str2);
            this.aos.setText(str3);
            this.apV.setText(str4);
            this.apV.setTag(str4);
            this.eIu.setText(str5);
            this.apV.setOnClickListener(this);
            rn(str);
            if (this.eUE != null) {
                this.eUE.setTag(strArr);
            }
            this.fLN.setTag(strArr);
            this.fLO.setTag(strArr);
        }
    }

    private void rn(String str) {
        if (fLQ != null && !fLQ.equals(str)) {
            fLP = null;
        }
        if (fLP != null) {
            this.fLT.setImageBitmap(fLP.kl());
            fLQ = str;
            return;
        }
        this.fLT.startLoad(str, 12, this.fLR, this.fLR, false);
    }

    public void dw(int i) {
        ak.c(this.apV, d.C0126d.cp_cont_d, 1);
        ak.c(this.aos, d.C0126d.cp_cont_d, 1);
        ak.c(this.apg, d.C0126d.cp_cont_f, 1);
        ak.i(this.mLayout, d.C0126d.cp_bg_line_c);
        ak.i(this.fLM, d.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.eIu.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.c(this.eIu, d.C0126d.cp_link_tip_c, 1);
    }
}
