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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes7.dex */
public class PersonCommentHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private static a mtV;
    private static String mtW;
    public TextView akj;
    public TextView fhC;
    public TextView fiz;
    private final LinearLayout loO;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    public ReplyLinearLayout mtQ;
    public TextView mtR;
    protected final LinearLayout mtS;
    protected final ColumnLayout mtT;
    protected final ColumnLayout mtU;
    private int mtX;
    public LinearLayout mtY;
    public HeadImageView mtZ;
    public TextView mua;

    public PersonCommentHolder(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mtQ = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.mtQ.setIsHost(this.mIsHost);
        this.mtR = (TextView) view.findViewById(R.id.original_post_title);
        this.mtY = (LinearLayout) view.findViewById(R.id.top_line);
        this.mtZ = (HeadImageView) view.findViewById(R.id.portrait);
        this.akj = (TextView) view.findViewById(R.id.username);
        this.fhC = (TextView) view.findViewById(R.id.reply_time);
        this.fiz = (TextView) view.findViewById(R.id.forum_name);
        this.mua = (TextView) view.findViewById(R.id.reply_count);
        this.loO = (LinearLayout) view.findViewById(R.id.item_content);
        this.mtT = (ColumnLayout) view.findViewById(R.id.item_header);
        this.mtU = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mtS = (LinearLayout) view.findViewById(R.id.person_child);
        this.mtX = l.dip2px(view.getContext(), 42.0f);
        if (this.loO != null) {
            this.loO.setOnClickListener(this);
        }
        this.mtZ.setOnClickListener(this);
        this.akj.setOnClickListener(this);
        this.fiz.setOnClickListener(this);
        this.mua.setOnClickListener(this);
        this.mtT.setOnClickListener(this);
        this.mtU.setOnClickListener(this);
        this.mtR.setOnClickListener(this);
    }

    public void changeSkin(int i) {
        ao.setBackgroundResource(this.mtR, R.color.CAM_X0205);
        ao.setBackgroundColor(getView(), R.color.CAM_X0204);
        ao.setBackgroundResource(this.mtS, R.drawable.daily_recommend_item_selector);
        ao.setViewTextColor(this.akj, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.fhC, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.fiz, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.mua, R.color.CAM_X0109, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new aq("c12043").an("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.fiz) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.mtR && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
                            str4 = at.getFormatTime(postInfoList.create_time * 1000);
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
                            str4 = at.getFormatTime(postInfoList.create_time * 1000);
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
            this.akj.setText(str5);
            this.fhC.setText(str4);
            this.fiz.setText(str3);
            this.fiz.setTag(str3);
            this.mua.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str2));
            this.fiz.setOnClickListener(this);
            PJ(str);
            if (this.loO != null) {
                this.loO.setTag(strArr);
            }
            this.mtT.setTag(strArr);
            this.mtU.setTag(strArr);
        }
    }

    private void PJ(String str) {
        if (mtW != null && !mtW.equals(str)) {
            mtV = null;
        }
        if (mtV != null) {
            this.mtZ.setImageBitmap(mtV.getRawBitmap());
            mtW = str;
            return;
        }
        this.mtZ.a(str, 12, this.mtX, this.mtX, false);
    }
}
