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
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a ikY;
    private static String ikZ;
    public TextView Xq;
    public TextView bZX;
    public TextView caU;
    public HeadImageView fIM;
    private final LinearLayout hsl;
    protected final LinearLayout ikV;
    protected final ColumnLayout ikW;
    protected final ColumnLayout ikX;
    private int ila;
    public LinearLayout ilb;
    public TextView ilc;
    private InterfaceC0389a itL;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0389a {
        void cJ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ilb = (LinearLayout) view.findViewById(R.id.top_line);
        this.fIM = (HeadImageView) view.findViewById(R.id.portrait);
        this.Xq = (TextView) view.findViewById(R.id.username);
        this.bZX = (TextView) view.findViewById(R.id.reply_time);
        this.caU = (TextView) view.findViewById(R.id.forum_name);
        this.ilc = (TextView) view.findViewById(R.id.reply_count);
        this.hsl = (LinearLayout) view.findViewById(R.id.item_content);
        this.ikW = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ikX = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.ikV = (LinearLayout) view.findViewById(R.id.person_child);
        this.ila = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hsl != null) {
            this.hsl.setOnClickListener(this);
        }
        this.fIM.setOnClickListener(this);
        this.Xq.setOnClickListener(this);
        this.caU.setOnClickListener(this);
        this.ilc.setOnClickListener(this);
        this.ikW.setOnClickListener(this);
        this.ikX.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.itL != null) {
            this.itL.cJ(view);
        }
    }

    public void a(InterfaceC0389a interfaceC0389a) {
        this.itL = interfaceC0389a;
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
                str3 = ap.aC(postInfoList.create_time * 1000);
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
                str3 = ap.aC(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.Xq.setText(str2);
            this.bZX.setText(str3);
            this.caU.setText(str4);
            this.caU.setTag(str4);
            this.ilc.setText(str5);
            this.caU.setOnClickListener(this);
            Ce(str);
            if (this.hsl != null) {
                this.hsl.setTag(strArr);
            }
            this.ikW.setTag(strArr);
            this.ikX.setTag(strArr);
        }
    }

    private void Ce(String str) {
        if (ikZ != null && !ikZ.equals(str)) {
            ikY = null;
        }
        if (ikY != null) {
            this.fIM.setImageBitmap(ikY.ns());
            ikZ = str;
            return;
        }
        this.fIM.startLoad(str, 12, this.ila, this.ila, false);
    }

    public void iP(int i) {
        al.f(this.caU, R.color.cp_cont_d, 1);
        al.f(this.bZX, R.color.cp_cont_d, 1);
        al.f(this.Xq, R.color.cp_cont_f, 1);
        al.k(this.mLayout, R.color.cp_bg_line_c);
        al.k(this.ikV, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.ilc.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.f(this.ilc, R.color.cp_link_tip_c, 1);
    }
}
