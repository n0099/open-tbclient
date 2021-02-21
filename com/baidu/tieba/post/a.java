package com.baidu.tieba.post;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a mDm;
    private static String mDn;
    public TextView ajY;
    public TextView fjV;
    public ImageView fjY;
    public TextView fkQ;
    private final LinearLayout kPe;
    private final LinearLayout lxf;
    protected final LinearLayout mDj;
    protected final ColumnLayout mDk;
    protected final ColumnLayout mDl;
    private int mDo;
    public LinearLayout mDp;
    public HeadImageView mDq;
    public TextView mDr;
    private InterfaceC0850a mLI;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0850a {
        void dY(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mDp = (LinearLayout) view.findViewById(R.id.top_line);
        this.mDq = (HeadImageView) view.findViewById(R.id.portrait);
        this.ajY = (TextView) view.findViewById(R.id.username);
        this.fjV = (TextView) view.findViewById(R.id.reply_time);
        this.fkQ = (TextView) view.findViewById(R.id.forum_name);
        this.mDr = (TextView) view.findViewById(R.id.reply_count);
        this.lxf = (LinearLayout) view.findViewById(R.id.item_content);
        this.mDk = (ColumnLayout) view.findViewById(R.id.item_header);
        this.mDl = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.kPe = (LinearLayout) view.findViewById(R.id.person_thread);
        this.mDj = (LinearLayout) view.findViewById(R.id.person_child);
        this.fjY = (ImageView) view.findViewById(R.id.comment_icon);
        this.mDo = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.lxf != null) {
            this.lxf.setOnClickListener(this);
        }
        this.mDq.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.fkQ.setOnClickListener(this);
        this.mDr.setOnClickListener(this);
        this.mDk.setOnClickListener(this);
        this.mDl.setOnClickListener(this);
        this.mDr.setText(R.string.reply_me);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.mLI != null) {
            this.mLI.dY(view);
        }
    }

    public void a(InterfaceC0850a interfaceC0850a) {
        this.mLI = interfaceC0850a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            str5 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            str4 = au.getFormatTime(postInfoList.create_time * 1000);
                            str3 = postInfoList.forum_name;
                            str2 = String.valueOf(postInfoList.reply_num);
                            try {
                                strArr[3] = String.valueOf(postInfoList.thread_type);
                            } catch (Exception e) {
                                str6 = null;
                                if (str6 == null) {
                                }
                            }
                        } else {
                            str5 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = au.getFormatTime(postInfoList.create_time * 1000);
                            str3 = postInfoList.forum_name;
                            str2 = String.valueOf(postInfoList.reply_num);
                        }
                        str6 = 1;
                    } catch (Exception e2) {
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                    }
                } catch (Exception e3) {
                    str2 = str6;
                    str3 = str6;
                }
            } catch (Exception e4) {
                str2 = str6;
                str3 = str6;
                str4 = str6;
            }
        } catch (Exception e5) {
            str2 = str6;
        }
        if (str6 == null) {
            this.ajY.setText(str5);
            this.fjV.setText(str4);
            this.fkQ.setText(str3);
            this.fkQ.setTag(str3);
            this.mDr.setText(str2);
            this.mDr.setTag(strArr);
            this.fkQ.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                QB(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                QB(str);
            }
            if (this.lxf != null) {
                this.lxf.setTag(strArr);
            }
            this.mDk.setTag(strArr);
            this.mDl.setTag(strArr);
        }
    }

    private void QB(String str) {
        if (mDn != null && !mDn.equals(str)) {
            mDm = null;
        }
        if (mDm != null) {
            this.mDq.setImageBitmap(mDm.getRawBitmap());
            mDn = str;
            return;
        }
        this.mDq.a(str, 12, this.mDo, this.mDo, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.fkQ, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.fjV, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.ajY, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.kPe, R.color.CAM_X0204);
        ap.setBackgroundResource(this.mDj, R.color.CAM_X0201);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        ap.setViewTextColor(this.mDr, R.color.CAM_X0105);
        WebPManager.a(this.fjY, R.drawable.icon_pure_card_comment22, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }
}
