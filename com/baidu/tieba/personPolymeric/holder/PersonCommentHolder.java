package com.baidu.tieba.personPolymeric.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes8.dex */
public class PersonCommentHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private static a mCW;
    private static String mCX;
    public TextView ajY;
    public TextView fjV;
    public TextView fkQ;
    private final LinearLayout lwR;
    public ReplyLinearLayout mCR;
    public TextView mCS;
    protected final LinearLayout mCT;
    protected final ColumnLayout mCU;
    protected final ColumnLayout mCV;
    private int mCY;
    public LinearLayout mCZ;
    public HeadImageView mDa;
    public TextView mDc;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public PersonCommentHolder(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mCR = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.mCR.setIsHost(this.mIsHost);
        this.mCS = (TextView) view.findViewById(R.id.original_post_title);
        this.mCZ = (LinearLayout) view.findViewById(R.id.top_line);
        this.mDa = (HeadImageView) view.findViewById(R.id.portrait);
        this.ajY = (TextView) view.findViewById(R.id.username);
        this.fjV = (TextView) view.findViewById(R.id.reply_time);
        this.fkQ = (TextView) view.findViewById(R.id.forum_name);
        this.mDc = (TextView) view.findViewById(R.id.reply_count);
        this.lwR = (LinearLayout) view.findViewById(R.id.item_content);
        this.mCU = (ColumnLayout) view.findViewById(R.id.item_header);
        this.mCV = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mCT = (LinearLayout) view.findViewById(R.id.person_child);
        this.mCY = l.dip2px(view.getContext(), 42.0f);
        if (this.lwR != null) {
            this.lwR.setOnClickListener(this);
        }
        this.mDa.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.fkQ.setOnClickListener(this);
        this.mDc.setOnClickListener(this);
        this.mCU.setOnClickListener(this);
        this.mCV.setOnClickListener(this);
        this.mCS.setOnClickListener(this);
    }

    public void changeSkin(int i) {
        ap.setBackgroundResource(this.mCS, R.color.CAM_X0205);
        ap.setBackgroundColor(getView(), R.color.CAM_X0204);
        ap.setBackgroundResource(this.mCT, R.drawable.daily_recommend_item_selector);
        ap.setViewTextColor(this.ajY, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.fjV, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.fkQ, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mDc, R.color.CAM_X0109, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ar("c12043").ap("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.fkQ) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.mCS && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
            }
        }
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
                            str5 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
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
                            str5 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
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
                }
            } catch (Exception e4) {
                str2 = str6;
                str3 = str6;
            }
        } catch (Exception e5) {
            str2 = str6;
            str3 = str6;
            str4 = str6;
        }
        if (str6 == null) {
            this.ajY.setText(str5);
            this.fjV.setText(str4);
            this.fkQ.setText(str3);
            this.fkQ.setTag(str3);
            this.mDc.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str2));
            this.fkQ.setOnClickListener(this);
            QA(str);
            if (this.lwR != null) {
                this.lwR.setTag(strArr);
            }
            this.mCU.setTag(strArr);
            this.mCV.setTag(strArr);
        }
    }

    private void QA(String str) {
        if (mCX != null && !mCX.equals(str)) {
            mCW = null;
        }
        if (mCW != null) {
            this.mDa.setImageBitmap(mCW.getRawBitmap());
            mCX = str;
            return;
        }
        this.mDa.a(str, 12, this.mCY, this.mCY, false);
    }
}
