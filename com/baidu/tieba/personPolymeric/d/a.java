package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes11.dex */
public class a extends y.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a kbS;
    private static String kbT;
    public TextView afW;
    public TextView dHA;
    public TextView dIy;
    private final LinearLayout jez;
    public ReplyLinearLayout kbN;
    public TextView kbO;
    protected final LinearLayout kbP;
    protected final ColumnLayout kbQ;
    protected final ColumnLayout kbR;
    private int kbU;
    public LinearLayout kbV;
    public HeadImageView kbW;
    public TextView kbX;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.kbN = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.kbN.setIsHost(this.mIsHost);
        this.kbO = (TextView) view.findViewById(R.id.original_post_title);
        this.kbV = (LinearLayout) view.findViewById(R.id.top_line);
        this.kbW = (HeadImageView) view.findViewById(R.id.portrait);
        this.afW = (TextView) view.findViewById(R.id.username);
        this.dHA = (TextView) view.findViewById(R.id.reply_time);
        this.dIy = (TextView) view.findViewById(R.id.forum_name);
        this.kbX = (TextView) view.findViewById(R.id.reply_count);
        this.jez = (LinearLayout) view.findViewById(R.id.item_content);
        this.kbQ = (ColumnLayout) view.findViewById(R.id.item_header);
        this.kbR = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.kbP = (LinearLayout) view.findViewById(R.id.person_child);
        this.kbU = l.dip2px(view.getContext(), 42.0f);
        if (this.jez != null) {
            this.jez.setOnClickListener(this);
        }
        this.kbW.setOnClickListener(this);
        this.afW.setOnClickListener(this);
        this.dIy.setOnClickListener(this);
        this.kbX.setOnClickListener(this);
        this.kbQ.setOnClickListener(this);
        this.kbR.setOnClickListener(this);
        this.kbO.setOnClickListener(this);
    }

    public void changeSkin(int i) {
        am.setBackgroundResource(this.kbO, R.color.cp_bg_line_e);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_c);
        am.setBackgroundResource(this.kbP, R.drawable.daily_recommend_item_selector);
        am.setViewTextColor(this.afW, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dHA, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dIy, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.kbX, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new an("c12043").af("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.dIy) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.kbO && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String formatTime;
        String str7;
        String valueOf;
        String str8 = null;
        String str9 = 4;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            formatTime = aq.getFormatTime(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            formatTime = aq.getFormatTime(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = formatTime;
                        str2 = str7;
                        str9 = valueOf;
                        str8 = 1;
                        str5 = str9;
                    } catch (Exception e) {
                        str9 = str8;
                        str4 = str3;
                        str3 = str2;
                        str2 = str9;
                        str5 = str8;
                        str8 = null;
                        if (str8 != null) {
                        }
                    }
                } catch (Exception e2) {
                    str9 = str8;
                    str2 = str8;
                    str4 = str3;
                    str3 = str2;
                    str2 = str9;
                    str5 = str8;
                    str8 = null;
                    if (str8 != null) {
                    }
                }
            } catch (Exception e3) {
                str9 = 0;
                str2 = null;
                str3 = null;
                str4 = str3;
                str3 = str2;
                str2 = str9;
                str5 = str8;
                str8 = null;
                if (str8 != null) {
                }
            }
        } catch (Exception e4) {
            str4 = str3;
            str3 = str2;
            str2 = str9;
            str5 = str8;
            str8 = null;
            if (str8 != null) {
            }
        }
        if (str8 != null) {
            this.afW.setText(str4);
            this.dHA.setText(str3);
            this.dIy.setText(str2);
            this.dIy.setTag(str2);
            this.kbX.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.dIy.setOnClickListener(this);
            ID(str);
            if (this.jez != null) {
                this.jez.setTag(strArr);
            }
            this.kbQ.setTag(strArr);
            this.kbR.setTag(strArr);
        }
    }

    private void ID(String str) {
        if (kbT != null && !kbT.equals(str)) {
            kbS = null;
        }
        if (kbS != null) {
            this.kbW.setImageBitmap(kbS.getRawBitmap());
            kbT = str;
            return;
        }
        this.kbW.a(str, 12, this.kbU, this.kbU, false);
    }
}
