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
    private static com.baidu.adp.widget.a.a gql;
    private static String gqm;
    public TextView bdP;
    public TextView bda;
    public TextView beF;
    public TextView fmM;
    private final LinearLayout fyP;
    protected final LinearLayout gqi;
    protected final ColumnLayout gqj;
    protected final ColumnLayout gqk;
    private int gqn;
    public LinearLayout gqo;
    public HeadImageView gqp;
    private InterfaceC0221a gxg;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0221a {
        void cJ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gqo = (LinearLayout) view.findViewById(d.g.top_line);
        this.gqp = (HeadImageView) view.findViewById(d.g.portrait);
        this.bdP = (TextView) view.findViewById(d.g.username);
        this.bda = (TextView) view.findViewById(d.g.reply_time);
        this.beF = (TextView) view.findViewById(d.g.forum_name);
        this.fmM = (TextView) view.findViewById(d.g.reply_count);
        this.fyP = (LinearLayout) view.findViewById(d.g.item_content);
        this.gqj = (ColumnLayout) view.findViewById(d.g.item_header);
        this.gqk = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.gqi = (LinearLayout) view.findViewById(d.g.person_child);
        this.gqn = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fyP != null) {
            this.fyP.setOnClickListener(this);
        }
        this.gqp.setOnClickListener(this);
        this.bdP.setOnClickListener(this);
        this.beF.setOnClickListener(this);
        this.fmM.setOnClickListener(this);
        this.gqj.setOnClickListener(this);
        this.gqk.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gxg != null) {
            this.gxg.cJ(view);
        }
    }

    public void a(InterfaceC0221a interfaceC0221a) {
        this.gxg = interfaceC0221a;
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
            this.bdP.setText(str2);
            this.bda.setText(str3);
            this.beF.setText(str4);
            this.beF.setTag(str4);
            this.fmM.setText(str5);
            this.beF.setOnClickListener(this);
            fM(str);
            if (this.fyP != null) {
                this.fyP.setTag(strArr);
            }
            this.gqj.setTag(strArr);
            this.gqk.setTag(strArr);
        }
    }

    private void fM(String str) {
        if (gqm != null && !gqm.equals(str)) {
            gql = null;
        }
        if (gql != null) {
            this.gqp.setImageBitmap(gql.sh());
            gqm = str;
            return;
        }
        this.gqp.startLoad(str, 12, this.gqn, this.gqn, false);
    }

    public void gx(int i) {
        aj.e(this.beF, d.C0141d.cp_cont_d, 1);
        aj.e(this.bda, d.C0141d.cp_cont_d, 1);
        aj.e(this.bdP, d.C0141d.cp_cont_f, 1);
        aj.s(this.mLayout, d.C0141d.cp_bg_line_c);
        aj.s(this.gqi, d.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.fmM.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.e(this.fmM, d.C0141d.cp_link_tip_c, 1);
    }
}
