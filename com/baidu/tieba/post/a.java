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
    private static com.baidu.adp.widget.ImageView.a fKJ;
    private static String fKK;
    public TextView aos;
    public TextView apV;
    public TextView apg;
    public TextView eHm;
    private final LinearLayout eTx;
    protected final LinearLayout fKG;
    protected final ColumnLayout fKH;
    protected final ColumnLayout fKI;
    private int fKL;
    public LinearLayout fKM;
    public HeadImageView fKN;
    private InterfaceC0203a fRP;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0203a {
        void bp(View view2);
    }

    public a(View view2, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fKM = (LinearLayout) view2.findViewById(d.g.top_line);
        this.fKN = (HeadImageView) view2.findViewById(d.g.portrait);
        this.apg = (TextView) view2.findViewById(d.g.username);
        this.aos = (TextView) view2.findViewById(d.g.reply_time);
        this.apV = (TextView) view2.findViewById(d.g.forum_name);
        this.eHm = (TextView) view2.findViewById(d.g.reply_count);
        this.eTx = (LinearLayout) view2.findViewById(d.g.item_content);
        this.fKH = (ColumnLayout) view2.findViewById(d.g.item_header);
        this.fKI = (ColumnLayout) view2.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view2.findViewById(d.g.person_thread);
        this.fKG = (LinearLayout) view2.findViewById(d.g.person_child);
        this.fKL = com.baidu.adp.lib.util.l.dip2px(view2.getContext(), 42.0f);
        if (this.eTx != null) {
            this.eTx.setOnClickListener(this);
        }
        this.fKN.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.apV.setOnClickListener(this);
        this.eHm.setOnClickListener(this);
        this.fKH.setOnClickListener(this);
        this.fKI.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view2.getTag(), "")));
            }
        } else if (this.fRP != null) {
            this.fRP.bp(view2);
        }
    }

    public void a(InterfaceC0203a interfaceC0203a) {
        this.fRP = interfaceC0203a;
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
            this.eHm.setText(str5);
            this.apV.setOnClickListener(this);
            rk(str);
            if (this.eTx != null) {
                this.eTx.setTag(strArr);
            }
            this.fKH.setTag(strArr);
            this.fKI.setTag(strArr);
        }
    }

    private void rk(String str) {
        if (fKK != null && !fKK.equals(str)) {
            fKJ = null;
        }
        if (fKJ != null) {
            this.fKN.setImageBitmap(fKJ.km());
            fKK = str;
            return;
        }
        this.fKN.startLoad(str, 12, this.fKL, this.fKL, false);
    }

    public void dv(int i) {
        ak.c(this.apV, d.C0126d.cp_cont_d, 1);
        ak.c(this.aos, d.C0126d.cp_cont_d, 1);
        ak.c(this.apg, d.C0126d.cp_cont_f, 1);
        ak.i(this.mLayout, d.C0126d.cp_bg_line_c);
        ak.i(this.fKG, d.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.eHm.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.c(this.eHm, d.C0126d.cp_link_tip_c, 1);
    }
}
