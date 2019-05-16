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
    private static com.baidu.adp.widget.ImageView.a ikU;
    private static String ikV;
    public TextView Xr;
    public TextView bZW;
    public TextView caT;
    public HeadImageView fIJ;
    private final LinearLayout hsh;
    protected final LinearLayout ikR;
    protected final ColumnLayout ikS;
    protected final ColumnLayout ikT;
    private int ikW;
    public LinearLayout ikX;
    public TextView ikY;
    private InterfaceC0389a itH;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0389a {
        void cJ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ikX = (LinearLayout) view.findViewById(R.id.top_line);
        this.fIJ = (HeadImageView) view.findViewById(R.id.portrait);
        this.Xr = (TextView) view.findViewById(R.id.username);
        this.bZW = (TextView) view.findViewById(R.id.reply_time);
        this.caT = (TextView) view.findViewById(R.id.forum_name);
        this.ikY = (TextView) view.findViewById(R.id.reply_count);
        this.hsh = (LinearLayout) view.findViewById(R.id.item_content);
        this.ikS = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ikT = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.ikR = (LinearLayout) view.findViewById(R.id.person_child);
        this.ikW = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hsh != null) {
            this.hsh.setOnClickListener(this);
        }
        this.fIJ.setOnClickListener(this);
        this.Xr.setOnClickListener(this);
        this.caT.setOnClickListener(this);
        this.ikY.setOnClickListener(this);
        this.ikS.setOnClickListener(this);
        this.ikT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.itH != null) {
            this.itH.cJ(view);
        }
    }

    public void a(InterfaceC0389a interfaceC0389a) {
        this.itH = interfaceC0389a;
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
            this.ikY.setText(str5);
            this.caT.setOnClickListener(this);
            Cc(str);
            if (this.hsh != null) {
                this.hsh.setTag(strArr);
            }
            this.ikS.setTag(strArr);
            this.ikT.setTag(strArr);
        }
    }

    private void Cc(String str) {
        if (ikV != null && !ikV.equals(str)) {
            ikU = null;
        }
        if (ikU != null) {
            this.fIJ.setImageBitmap(ikU.ns());
            ikV = str;
            return;
        }
        this.fIJ.startLoad(str, 12, this.ikW, this.ikW, false);
    }

    public void iP(int i) {
        al.f(this.caT, R.color.cp_cont_d, 1);
        al.f(this.bZW, R.color.cp_cont_d, 1);
        al.f(this.Xr, R.color.cp_cont_f, 1);
        al.k(this.mLayout, R.color.cp_bg_line_c);
        al.k(this.ikR, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.ikY.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.f(this.ikY, R.color.cp_link_tip_c, 1);
    }
}
