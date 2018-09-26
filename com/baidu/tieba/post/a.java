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
    private static com.baidu.adp.widget.ImageView.a giK;
    private static String giL;
    public TextView aAN;
    public TextView aBt;
    public TextView azZ;
    public HeadImageView dLj;
    private final LinearLayout frx;
    protected final LinearLayout giH;
    protected final ColumnLayout giI;
    protected final ColumnLayout giJ;
    private int giM;
    public LinearLayout giN;
    public TextView giO;
    private InterfaceC0226a gqc;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0226a {
        void bJ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.giN = (LinearLayout) view.findViewById(e.g.top_line);
        this.dLj = (HeadImageView) view.findViewById(e.g.portrait);
        this.aBt = (TextView) view.findViewById(e.g.username);
        this.azZ = (TextView) view.findViewById(e.g.reply_time);
        this.aAN = (TextView) view.findViewById(e.g.forum_name);
        this.giO = (TextView) view.findViewById(e.g.reply_count);
        this.frx = (LinearLayout) view.findViewById(e.g.item_content);
        this.giI = (ColumnLayout) view.findViewById(e.g.item_header);
        this.giJ = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(e.g.person_thread);
        this.giH = (LinearLayout) view.findViewById(e.g.person_child);
        this.giM = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.frx != null) {
            this.frx.setOnClickListener(this);
        }
        this.dLj.setOnClickListener(this);
        this.aBt.setOnClickListener(this);
        this.aAN.setOnClickListener(this);
        this.giO.setOnClickListener(this);
        this.giI.setOnClickListener(this);
        this.giJ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gqc != null) {
            this.gqc.bJ(view);
        }
    }

    public void a(InterfaceC0226a interfaceC0226a) {
        this.gqc = interfaceC0226a;
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
                str3 = ao.A(postInfoList.create_time * 1000);
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
                str3 = ao.A(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.aBt.setText(str2);
            this.azZ.setText(str3);
            this.aAN.setText(str4);
            this.aAN.setTag(str4);
            this.giO.setText(str5);
            this.aAN.setOnClickListener(this);
            sH(str);
            if (this.frx != null) {
                this.frx.setTag(strArr);
            }
            this.giI.setTag(strArr);
            this.giJ.setTag(strArr);
        }
    }

    private void sH(String str) {
        if (giL != null && !giL.equals(str)) {
            giK = null;
        }
        if (giK != null) {
            this.dLj.setImageBitmap(giK.oh());
            giL = str;
            return;
        }
        this.dLj.startLoad(str, 12, this.giM, this.giM, false);
    }

    public void dM(int i) {
        al.c(this.aAN, e.d.cp_cont_d, 1);
        al.c(this.azZ, e.d.cp_cont_d, 1);
        al.c(this.aBt, e.d.cp_cont_f, 1);
        al.i(this.mLayout, e.d.cp_bg_line_c);
        al.i(this.giH, e.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.giO.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.giO, e.d.cp_link_tip_c, 1);
    }
}
