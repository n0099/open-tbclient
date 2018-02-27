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
    private static com.baidu.adp.widget.a.a gpV;
    private static String gpW;
    public TextView bcY;
    public TextView bdM;
    public TextView beC;
    public TextView fmw;
    private final LinearLayout fyz;
    protected final LinearLayout gpS;
    protected final ColumnLayout gpT;
    protected final ColumnLayout gpU;
    private int gpX;
    public LinearLayout gpY;
    public HeadImageView gpZ;
    private InterfaceC0221a gwQ;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0221a {
        void cJ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gpY = (LinearLayout) view.findViewById(d.g.top_line);
        this.gpZ = (HeadImageView) view.findViewById(d.g.portrait);
        this.bdM = (TextView) view.findViewById(d.g.username);
        this.bcY = (TextView) view.findViewById(d.g.reply_time);
        this.beC = (TextView) view.findViewById(d.g.forum_name);
        this.fmw = (TextView) view.findViewById(d.g.reply_count);
        this.fyz = (LinearLayout) view.findViewById(d.g.item_content);
        this.gpT = (ColumnLayout) view.findViewById(d.g.item_header);
        this.gpU = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.gpS = (LinearLayout) view.findViewById(d.g.person_child);
        this.gpX = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fyz != null) {
            this.fyz.setOnClickListener(this);
        }
        this.gpZ.setOnClickListener(this);
        this.bdM.setOnClickListener(this);
        this.beC.setOnClickListener(this);
        this.fmw.setOnClickListener(this);
        this.gpT.setOnClickListener(this);
        this.gpU.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gwQ != null) {
            this.gwQ.cJ(view);
        }
    }

    public void a(InterfaceC0221a interfaceC0221a) {
        this.gwQ = interfaceC0221a;
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
            this.bdM.setText(str2);
            this.bcY.setText(str3);
            this.beC.setText(str4);
            this.beC.setTag(str4);
            this.fmw.setText(str5);
            this.beC.setOnClickListener(this);
            fM(str);
            if (this.fyz != null) {
                this.fyz.setTag(strArr);
            }
            this.gpT.setTag(strArr);
            this.gpU.setTag(strArr);
        }
    }

    private void fM(String str) {
        if (gpW != null && !gpW.equals(str)) {
            gpV = null;
        }
        if (gpV != null) {
            this.gpZ.setImageBitmap(gpV.sh());
            gpW = str;
            return;
        }
        this.gpZ.startLoad(str, 12, this.gpX, this.gpX, false);
    }

    public void gx(int i) {
        aj.e(this.beC, d.C0141d.cp_cont_d, 1);
        aj.e(this.bcY, d.C0141d.cp_cont_d, 1);
        aj.e(this.bdM, d.C0141d.cp_cont_f, 1);
        aj.s(this.mLayout, d.C0141d.cp_bg_line_c);
        aj.s(this.gpS, d.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.fmw.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.e(this.fmw, d.C0141d.cp_link_tip_c, 1);
    }
}
