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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a kXP;
    private static String kXQ;
    public TextView ahr;
    public TextView ejA;
    public TextView ekx;
    private final LinearLayout jUD;
    private final LinearLayout jnc;
    protected final LinearLayout kXM;
    protected final ColumnLayout kXN;
    protected final ColumnLayout kXO;
    private int kXR;
    public LinearLayout kXS;
    public HeadImageView kXT;
    public TextView kXU;
    private InterfaceC0732a lfX;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0732a {
        void dc(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.kXS = (LinearLayout) view.findViewById(R.id.top_line);
        this.kXT = (HeadImageView) view.findViewById(R.id.portrait);
        this.ahr = (TextView) view.findViewById(R.id.username);
        this.ejA = (TextView) view.findViewById(R.id.reply_time);
        this.ekx = (TextView) view.findViewById(R.id.forum_name);
        this.kXU = (TextView) view.findViewById(R.id.reply_count);
        this.jUD = (LinearLayout) view.findViewById(R.id.item_content);
        this.kXN = (ColumnLayout) view.findViewById(R.id.item_header);
        this.kXO = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.jnc = (LinearLayout) view.findViewById(R.id.person_thread);
        this.kXM = (LinearLayout) view.findViewById(R.id.person_child);
        this.kXR = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.jUD != null) {
            this.jUD.setOnClickListener(this);
        }
        this.kXT.setOnClickListener(this);
        this.ahr.setOnClickListener(this);
        this.ekx.setOnClickListener(this);
        this.kXU.setOnClickListener(this);
        this.kXN.setOnClickListener(this);
        this.kXO.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.lfX != null) {
            this.lfX.dc(view);
        }
    }

    public void a(InterfaceC0732a interfaceC0732a) {
        this.lfX = interfaceC0732a;
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
                str3 = as.getFormatTime(postInfoList.create_time * 1000);
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
                str3 = as.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.ahr.setText(str2);
            this.ejA.setText(str3);
            this.ekx.setText(str4);
            this.ekx.setTag(str4);
            this.kXU.setText(str5);
            this.kXU.setTag(strArr);
            this.ekx.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                LI(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                LI(str);
            }
            if (this.jUD != null) {
                this.jUD.setTag(strArr);
            }
            this.kXN.setTag(strArr);
            this.kXO.setTag(strArr);
        }
    }

    private void LI(String str) {
        if (kXQ != null && !kXQ.equals(str)) {
            kXP = null;
        }
        if (kXP != null) {
            this.kXT.setImageBitmap(kXP.getRawBitmap());
            kXQ = str;
            return;
        }
        this.kXT.a(str, 12, this.kXR, this.kXR, false);
    }

    public void changeSkin(int i) {
        ao.setViewTextColor(this.ekx, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.ejA, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.ahr, R.color.cp_cont_f, 1);
        ao.setBackgroundResource(this.jnc, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.kXM, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.kXU.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setViewTextColor(this.kXU, R.color.cp_link_tip_c, 1);
    }
}
