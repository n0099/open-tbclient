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
    private static com.baidu.adp.widget.ImageView.a ikX;
    private static String ikY;
    public TextView Xr;
    public TextView bZW;
    public TextView caT;
    public HeadImageView fIK;
    private final LinearLayout hsk;
    protected final LinearLayout ikU;
    protected final ColumnLayout ikV;
    protected final ColumnLayout ikW;
    private int ikZ;
    public LinearLayout ila;
    public TextView ilb;
    private InterfaceC0389a itK;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0389a {
        void cJ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ila = (LinearLayout) view.findViewById(R.id.top_line);
        this.fIK = (HeadImageView) view.findViewById(R.id.portrait);
        this.Xr = (TextView) view.findViewById(R.id.username);
        this.bZW = (TextView) view.findViewById(R.id.reply_time);
        this.caT = (TextView) view.findViewById(R.id.forum_name);
        this.ilb = (TextView) view.findViewById(R.id.reply_count);
        this.hsk = (LinearLayout) view.findViewById(R.id.item_content);
        this.ikV = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ikW = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.ikU = (LinearLayout) view.findViewById(R.id.person_child);
        this.ikZ = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hsk != null) {
            this.hsk.setOnClickListener(this);
        }
        this.fIK.setOnClickListener(this);
        this.Xr.setOnClickListener(this);
        this.caT.setOnClickListener(this);
        this.ilb.setOnClickListener(this);
        this.ikV.setOnClickListener(this);
        this.ikW.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.itK != null) {
            this.itK.cJ(view);
        }
    }

    public void a(InterfaceC0389a interfaceC0389a) {
        this.itK = interfaceC0389a;
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
            this.Xr.setText(str2);
            this.bZW.setText(str3);
            this.caT.setText(str4);
            this.caT.setTag(str4);
            this.ilb.setText(str5);
            this.caT.setOnClickListener(this);
            Cc(str);
            if (this.hsk != null) {
                this.hsk.setTag(strArr);
            }
            this.ikV.setTag(strArr);
            this.ikW.setTag(strArr);
        }
    }

    private void Cc(String str) {
        if (ikY != null && !ikY.equals(str)) {
            ikX = null;
        }
        if (ikX != null) {
            this.fIK.setImageBitmap(ikX.ns());
            ikY = str;
            return;
        }
        this.fIK.startLoad(str, 12, this.ikZ, this.ikZ, false);
    }

    public void iP(int i) {
        al.f(this.caT, R.color.cp_cont_d, 1);
        al.f(this.bZW, R.color.cp_cont_d, 1);
        al.f(this.Xr, R.color.cp_cont_f, 1);
        al.k(this.mLayout, R.color.cp_bg_line_c);
        al.k(this.ikU, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.ilb.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.f(this.ilb, R.color.cp_link_tip_c, 1);
    }
}
