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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a hSh;
    private static String hSi;
    public TextView Zy;
    public TextView bSd;
    public TextView bTa;
    public HeadImageView fso;
    protected final LinearLayout hSe;
    protected final ColumnLayout hSf;
    protected final ColumnLayout hSg;
    private int hSj;
    public LinearLayout hSk;
    public TextView hSl;
    private final LinearLayout haP;
    private InterfaceC0370a ibc;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0370a {
        void cB(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hSk = (LinearLayout) view.findViewById(d.g.top_line);
        this.fso = (HeadImageView) view.findViewById(d.g.portrait);
        this.Zy = (TextView) view.findViewById(d.g.username);
        this.bSd = (TextView) view.findViewById(d.g.reply_time);
        this.bTa = (TextView) view.findViewById(d.g.forum_name);
        this.hSl = (TextView) view.findViewById(d.g.reply_count);
        this.haP = (LinearLayout) view.findViewById(d.g.item_content);
        this.hSf = (ColumnLayout) view.findViewById(d.g.item_header);
        this.hSg = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.hSe = (LinearLayout) view.findViewById(d.g.person_child);
        this.hSj = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.haP != null) {
            this.haP.setOnClickListener(this);
        }
        this.fso.setOnClickListener(this);
        this.Zy.setOnClickListener(this);
        this.bTa.setOnClickListener(this);
        this.hSl.setOnClickListener(this);
        this.hSf.setOnClickListener(this);
        this.hSg.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.ibc != null) {
            this.ibc.cB(view);
        }
    }

    public void a(InterfaceC0370a interfaceC0370a) {
        this.ibc = interfaceC0370a;
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
                str3 = ap.ao(postInfoList.create_time * 1000);
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
                str3 = ap.ao(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.Zy.setText(str2);
            this.bSd.setText(str3);
            this.bTa.setText(str4);
            this.bTa.setTag(str4);
            this.hSl.setText(str5);
            this.bTa.setOnClickListener(this);
            AK(str);
            if (this.haP != null) {
                this.haP.setTag(strArr);
            }
            this.hSf.setTag(strArr);
            this.hSg.setTag(strArr);
        }
    }

    private void AK(String str) {
        if (hSi != null && !hSi.equals(str)) {
            hSh = null;
        }
        if (hSh != null) {
            this.fso.setImageBitmap(hSh.oy());
            hSi = str;
            return;
        }
        this.fso.startLoad(str, 12, this.hSj, this.hSj, false);
    }

    public void ib(int i) {
        al.d(this.bTa, d.C0277d.cp_cont_d, 1);
        al.d(this.bSd, d.C0277d.cp_cont_d, 1);
        al.d(this.Zy, d.C0277d.cp_cont_f, 1);
        al.k(this.mLayout, d.C0277d.cp_bg_line_c);
        al.k(this.hSe, d.C0277d.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.hSl.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.d(this.hSl, d.C0277d.cp_link_tip_c, 1);
    }
}
