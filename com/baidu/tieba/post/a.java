package com.baidu.tieba.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a lnU;
    private static String lnV;
    public TextView aiF;
    public TextView etv;
    public TextView eus;
    private final LinearLayout jCa;
    private final LinearLayout kjZ;
    protected final LinearLayout lnR;
    protected final ColumnLayout lnS;
    protected final ColumnLayout lnT;
    private int lnW;
    public LinearLayout lnX;
    public HeadImageView lnY;
    public TextView lnZ;
    private InterfaceC0783a lwq;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0783a {
        void dg(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.lnX = (LinearLayout) view.findViewById(R.id.top_line);
        this.lnY = (HeadImageView) view.findViewById(R.id.portrait);
        this.aiF = (TextView) view.findViewById(R.id.username);
        this.etv = (TextView) view.findViewById(R.id.reply_time);
        this.eus = (TextView) view.findViewById(R.id.forum_name);
        this.lnZ = (TextView) view.findViewById(R.id.reply_count);
        this.kjZ = (LinearLayout) view.findViewById(R.id.item_content);
        this.lnS = (ColumnLayout) view.findViewById(R.id.item_header);
        this.lnT = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.jCa = (LinearLayout) view.findViewById(R.id.person_thread);
        this.lnR = (LinearLayout) view.findViewById(R.id.person_child);
        this.lnW = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.kjZ != null) {
            this.kjZ.setOnClickListener(this);
        }
        this.lnY.setOnClickListener(this);
        this.aiF.setOnClickListener(this);
        this.eus.setOnClickListener(this);
        this.lnZ.setOnClickListener(this);
        this.lnS.setOnClickListener(this);
        this.lnT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.lwq != null) {
            this.lwq.dg(view);
        }
    }

    public void a(InterfaceC0783a interfaceC0783a) {
        this.lwq = interfaceC0783a;
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
                str3 = at.getFormatTime(postInfoList.create_time * 1000);
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
                str3 = at.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.aiF.setText(str2);
            this.etv.setText(str3);
            this.eus.setText(str4);
            this.eus.setTag(str4);
            this.lnZ.setText(str5);
            this.lnZ.setTag(strArr);
            this.eus.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                OB(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                OB(str);
            }
            if (this.kjZ != null) {
                this.kjZ.setTag(strArr);
            }
            this.lnS.setTag(strArr);
            this.lnT.setTag(strArr);
        }
    }

    private void OB(String str) {
        if (lnV != null && !lnV.equals(str)) {
            lnU = null;
        }
        if (lnU != null) {
            this.lnY.setImageBitmap(lnU.getRawBitmap());
            lnV = str;
            return;
        }
        this.lnY.a(str, 12, this.lnW, this.lnW, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.eus, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.etv, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.aiF, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.jCa, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.lnR, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.lnZ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.lnZ, R.color.cp_link_tip_c, 1);
    }
}
