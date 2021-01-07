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
/* loaded from: classes8.dex */
public class PersonCommentHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private static String myA;
    private static a myz;
    public TextView ala;
    public TextView fmn;
    public TextView fni;
    private final LinearLayout ltu;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    private int myB;
    public LinearLayout myC;
    public HeadImageView myD;
    public TextView myE;
    public ReplyLinearLayout myu;
    public TextView myv;
    protected final LinearLayout myw;
    protected final ColumnLayout myx;
    protected final ColumnLayout myy;

    public PersonCommentHolder(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.myu = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.myu.setIsHost(this.mIsHost);
        this.myv = (TextView) view.findViewById(R.id.original_post_title);
        this.myC = (LinearLayout) view.findViewById(R.id.top_line);
        this.myD = (HeadImageView) view.findViewById(R.id.portrait);
        this.ala = (TextView) view.findViewById(R.id.username);
        this.fmn = (TextView) view.findViewById(R.id.reply_time);
        this.fni = (TextView) view.findViewById(R.id.forum_name);
        this.myE = (TextView) view.findViewById(R.id.reply_count);
        this.ltu = (LinearLayout) view.findViewById(R.id.item_content);
        this.myx = (ColumnLayout) view.findViewById(R.id.item_header);
        this.myy = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.myw = (LinearLayout) view.findViewById(R.id.person_child);
        this.myB = l.dip2px(view.getContext(), 42.0f);
        if (this.ltu != null) {
            this.ltu.setOnClickListener(this);
        }
        this.myD.setOnClickListener(this);
        this.ala.setOnClickListener(this);
        this.fni.setOnClickListener(this);
        this.myE.setOnClickListener(this);
        this.myx.setOnClickListener(this);
        this.myy.setOnClickListener(this);
        this.myv.setOnClickListener(this);
    }

    public void changeSkin(int i) {
        ao.setBackgroundResource(this.myv, R.color.CAM_X0205);
        ao.setBackgroundColor(getView(), R.color.CAM_X0204);
        ao.setBackgroundResource(this.myw, R.drawable.daily_recommend_item_selector);
        ao.setViewTextColor(this.ala, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.fmn, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.fni, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.myE, R.color.CAM_X0109, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new aq("c12043").an("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.fni) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.myv && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
            this.ala.setText(str5);
            this.fmn.setText(str4);
            this.fni.setText(str3);
            this.fni.setTag(str3);
            this.myE.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str2));
            this.fni.setOnClickListener(this);
            QQ(str);
            if (this.ltu != null) {
                this.ltu.setTag(strArr);
            }
            this.myx.setTag(strArr);
            this.myy.setTag(strArr);
        }
    }

    private void QQ(String str) {
        if (myA != null && !myA.equals(str)) {
            myz = null;
        }
        if (myz != null) {
            this.myD.setImageBitmap(myz.getRawBitmap());
            myA = str;
            return;
        }
        this.myD.a(str, 12, this.myB, this.myB, false);
    }
}
