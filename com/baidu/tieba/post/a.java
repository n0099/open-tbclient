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
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a fXb;
    private static String fXc;
    public TextView awA;
    public TextView axo;
    public TextView ayc;
    public TextView eTN;
    protected final LinearLayout fWY;
    protected final ColumnLayout fWZ;
    protected final ColumnLayout fXa;
    private int fXd;
    public LinearLayout fXe;
    public HeadImageView fXf;
    private final LinearLayout ffW;
    private InterfaceC0219a gei;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0219a {
        void bs(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fXe = (LinearLayout) view.findViewById(d.g.top_line);
        this.fXf = (HeadImageView) view.findViewById(d.g.portrait);
        this.axo = (TextView) view.findViewById(d.g.username);
        this.awA = (TextView) view.findViewById(d.g.reply_time);
        this.ayc = (TextView) view.findViewById(d.g.forum_name);
        this.eTN = (TextView) view.findViewById(d.g.reply_count);
        this.ffW = (LinearLayout) view.findViewById(d.g.item_content);
        this.fWZ = (ColumnLayout) view.findViewById(d.g.item_header);
        this.fXa = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.fWY = (LinearLayout) view.findViewById(d.g.person_child);
        this.fXd = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.ffW != null) {
            this.ffW.setOnClickListener(this);
        }
        this.fXf.setOnClickListener(this);
        this.axo.setOnClickListener(this);
        this.ayc.setOnClickListener(this);
        this.eTN.setOnClickListener(this);
        this.fWZ.setOnClickListener(this);
        this.fXa.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gei != null) {
            this.gei.bs(view);
        }
    }

    public void a(InterfaceC0219a interfaceC0219a) {
        this.gei = interfaceC0219a;
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
                str3 = ao.v(postInfoList.create_time * 1000);
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
                str3 = ao.v(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.axo.setText(str2);
            this.awA.setText(str3);
            this.ayc.setText(str4);
            this.ayc.setTag(str4);
            this.eTN.setText(str5);
            this.ayc.setOnClickListener(this);
            se(str);
            if (this.ffW != null) {
                this.ffW.setTag(strArr);
            }
            this.fWZ.setTag(strArr);
            this.fXa.setTag(strArr);
        }
    }

    private void se(String str) {
        if (fXc != null && !fXc.equals(str)) {
            fXb = null;
        }
        if (fXb != null) {
            this.fXf.setImageBitmap(fXb.mZ());
            fXc = str;
            return;
        }
        this.fXf.startLoad(str, 12, this.fXd, this.fXd, false);
    }

    public void dy(int i) {
        al.c(this.ayc, d.C0141d.cp_cont_d, 1);
        al.c(this.awA, d.C0141d.cp_cont_d, 1);
        al.c(this.axo, d.C0141d.cp_cont_f, 1);
        al.i(this.mLayout, d.C0141d.cp_bg_line_c);
        al.i(this.fWY, d.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.eTN.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eTN, d.C0141d.cp_link_tip_c, 1);
    }
}
