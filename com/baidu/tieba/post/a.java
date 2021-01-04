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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a myA;
    private static String myB;
    public TextView ala;
    public TextView fmn;
    public TextView fni;
    private final LinearLayout kLr;
    private final LinearLayout ltu;
    private InterfaceC0830a mGU;
    private TbPageContext<?> mPageContext;
    private int myC;
    public LinearLayout myD;
    public HeadImageView myE;
    public TextView myF;
    protected final LinearLayout myx;
    protected final ColumnLayout myy;
    protected final ColumnLayout myz;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0830a {
        void ea(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.myD = (LinearLayout) view.findViewById(R.id.top_line);
        this.myE = (HeadImageView) view.findViewById(R.id.portrait);
        this.ala = (TextView) view.findViewById(R.id.username);
        this.fmn = (TextView) view.findViewById(R.id.reply_time);
        this.fni = (TextView) view.findViewById(R.id.forum_name);
        this.myF = (TextView) view.findViewById(R.id.reply_count);
        this.ltu = (LinearLayout) view.findViewById(R.id.item_content);
        this.myy = (ColumnLayout) view.findViewById(R.id.item_header);
        this.myz = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.kLr = (LinearLayout) view.findViewById(R.id.person_thread);
        this.myx = (LinearLayout) view.findViewById(R.id.person_child);
        this.myC = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.ltu != null) {
            this.ltu.setOnClickListener(this);
        }
        this.myE.setOnClickListener(this);
        this.ala.setOnClickListener(this);
        this.fni.setOnClickListener(this);
        this.myF.setOnClickListener(this);
        this.myy.setOnClickListener(this);
        this.myz.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.mGU != null) {
            this.mGU.ea(view);
        }
    }

    public void a(InterfaceC0830a interfaceC0830a) {
        this.mGU = interfaceC0830a;
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
                            str5 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
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
            this.ala.setText(str5);
            this.fmn.setText(str4);
            this.fni.setText(str3);
            this.fni.setTag(str3);
            this.myF.setText(str2);
            this.myF.setTag(strArr);
            this.fni.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                QR(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                QR(str);
            }
            if (this.ltu != null) {
                this.ltu.setTag(strArr);
            }
            this.myy.setTag(strArr);
            this.myz.setTag(strArr);
        }
    }

    private void QR(String str) {
        if (myB != null && !myB.equals(str)) {
            myA = null;
        }
        if (myA != null) {
            this.myE.setImageBitmap(myA.getRawBitmap());
            myB = str;
            return;
        }
        this.myE.a(str, 12, this.myC, this.myC, false);
    }

    public void changeSkin(int i) {
        ao.setViewTextColor(this.fni, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.fmn, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.ala, R.color.CAM_X0106, 1);
        ao.setBackgroundResource(this.kLr, R.color.CAM_X0204);
        ao.setBackgroundResource(this.myx, R.color.CAM_X0201);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.myF.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setViewTextColor(this.myF, R.color.CAM_X0304, 1);
    }
}
