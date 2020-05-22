package com.baidu.tieba.pb.pb.main.b;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private static final String USER_ICON_WEBVIEW = d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW;
    private final com.baidu.tieba.pb.pb.a jWc;
    public final View.OnClickListener gWJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            int i;
            String str4;
            String str5 = null;
            AlaInfoData alaInfoData = null;
            if (view instanceof HeadImageView) {
                String userId = ((HeadImageView) view).getUserId();
                String userName = ((HeadImageView) view).getUserName();
                String fid = ((HeadImageView) view).getFid();
                String tid = ((HeadImageView) view).getTid();
                String fName = ((HeadImageView) view).getFName();
                int floor = ((HeadImageView) view).getFloor();
                AlaInfoData alaInfo = ((HeadImageView) view).getAlaInfo();
                int liveStatus = ((HeadImageView) view).getLiveStatus();
                if (alaInfo != null && (liveStatus == 1 || alaInfo.live_status == 1)) {
                    an anVar = new an("c13715");
                    anVar.dh("fid", fid);
                    anVar.dh("fname", fName);
                    anVar.s("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                    anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.dh("tid", tid);
                    anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, floor);
                    TiebaStatic.log(anVar);
                    i = liveStatus;
                    str3 = userId;
                    alaInfoData = alaInfo;
                    str2 = userName;
                } else if (aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    i = liveStatus;
                    str3 = userId;
                    alaInfoData = alaInfo;
                    str2 = userName;
                } else {
                    an anVar2 = new an("c13267");
                    anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar2.dh("fid", fid);
                    anVar2.dh("tid", tid);
                    anVar2.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    i = liveStatus;
                    str3 = userId;
                    alaInfoData = alaInfo;
                    str2 = userName;
                }
            } else {
                if (view.getTag(R.id.tag_user_id) instanceof String) {
                    str = (String) view.getTag(R.id.tag_user_id);
                } else if (!(view.getTag() instanceof String)) {
                    str = null;
                } else {
                    str = (String) view.getTag();
                }
                if (view.getTag(R.id.tag_user_name) instanceof String) {
                    str5 = (String) view.getTag(R.id.tag_user_name);
                }
                if (!(view.getTag() instanceof SparseArray) || !(((SparseArray) view.getTag()).get(R.id.tag_user_id) instanceof String)) {
                    str2 = str5;
                    str3 = str;
                    i = -1;
                } else {
                    i = -1;
                    str2 = str5;
                    str3 = (String) ((SparseArray) view.getTag()).get(R.id.tag_user_id);
                }
            }
            if (view.getTag(R.id.tag_statistic_item) instanceof an) {
                TiebaStatic.log((an) view.getTag(R.id.tag_statistic_item));
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str6 = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str6) && bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(a.this.jWc.getPageContext().getPageActivity(), null, str6, true)));
                    return;
                }
            }
            if (!(view.getTag(R.id.tag_virtual_user_url) instanceof String)) {
                str4 = null;
            } else {
                str4 = (String) view.getTag(R.id.tag_virtual_user_url);
            }
            if (str4 != null) {
                if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                    ba.aUZ().b(a.this.jWc.getPageContext(), new String[]{str4});
                }
            } else if (str3 != null) {
                if (alaInfoData != null && (i == 1 || alaInfoData.live_status == 1)) {
                    if (alaInfoData.isChushou) {
                        ba.aUZ().b(a.this.jWc.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfoData.thirdRoomId + "&livetype=" + alaInfoData.thirdLiveType});
                        return;
                    } else if (alaInfoData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaInfoData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        return;
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.jWc.getPageContext().getPageActivity(), str3, str2, a.this.jWc.cDp(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    };
    public final View.OnClickListener jWd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(R.id.tag_user_id) instanceof String) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), a.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 2));
            }
        }
    };
    public final View.OnClickListener jWe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                String str = null;
                if (view.getTag() != null) {
                    str = (String) view.getTag();
                }
                if (str != null) {
                    ba.aUZ().b(a.this.jWc.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(a.this.jWc.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
            }
        }
    };
    public final TbRichTextView.h jWf = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.b.a.4
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(a.this.jWc.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };

    public a(com.baidu.tieba.pb.pb.a aVar) {
        this.jWc = aVar;
    }
}
