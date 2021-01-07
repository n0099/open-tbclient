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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a {
    private static final String USER_ICON_WEBVIEW = e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW;
    private final com.baidu.tieba.pb.pb.a lZw;
    public final View.OnClickListener iOE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            String str4;
            AlaInfoData alaInfoData = null;
            int i = -1;
            if (view instanceof HeadImageView) {
                str3 = ((HeadImageView) view).getUserId();
                str2 = ((HeadImageView) view).getUserName();
                String fid = ((HeadImageView) view).getFid();
                String tid = ((HeadImageView) view).getTid();
                String fName = ((HeadImageView) view).getFName();
                int floor = ((HeadImageView) view).getFloor();
                alaInfoData = ((HeadImageView) view).getAlaInfo();
                i = ((HeadImageView) view).getLiveStatus();
                if (alaInfoData != null && (i == 1 || alaInfoData.live_status == 1)) {
                    aq aqVar = new aq("c13715");
                    aqVar.dX("fid", fid);
                    aqVar.dX("fname", fName);
                    aqVar.w("obj_param1", alaInfoData.user_info != null ? alaInfoData.user_info.user_id : 0L);
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dX("tid", tid);
                    aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, floor);
                    TiebaStatic.log(aqVar);
                } else if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aq aqVar2 = new aq("c13267");
                    aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dX("fid", fid);
                    aqVar2.dX("tid", tid);
                    aqVar2.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar2);
                }
            } else {
                if (view.getTag(R.id.tag_user_id) instanceof String) {
                    str = (String) view.getTag(R.id.tag_user_id);
                } else if (!(view.getTag() instanceof String)) {
                    str = null;
                } else {
                    str = (String) view.getTag();
                }
                if (!(view.getTag(R.id.tag_user_name) instanceof String)) {
                    str2 = null;
                } else {
                    str2 = (String) view.getTag(R.id.tag_user_name);
                }
                str3 = ((view.getTag() instanceof SparseArray) && (((SparseArray) view.getTag()).get(R.id.tag_user_id) instanceof String)) ? (String) ((SparseArray) view.getTag()).get(R.id.tag_user_id) : str;
            }
            if (view.getTag(R.id.tag_statistic_item) instanceof aq) {
                TiebaStatic.log((aq) view.getTag(R.id.tag_statistic_item));
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str5 = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str5) && bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(a.this.lZw.getPageContext().getPageActivity(), null, str5, true)));
                    return;
                }
            }
            if (!(view.getTag(R.id.tag_virtual_user_url) instanceof String)) {
                str4 = null;
            } else {
                str4 = (String) view.getTag(R.id.tag_virtual_user_url);
            }
            if (str4 != null) {
                if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                    be.bwv().b(a.this.lZw.getPageContext(), new String[]{str4});
                }
            } else if (str3 != null) {
                if (alaInfoData != null && (i == 1 || alaInfoData.live_status == 1)) {
                    if (alaInfoData.isChushou) {
                        be.bwv().b(a.this.lZw.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfoData.thirdRoomId + "&livetype=" + alaInfoData.thirdLiveType});
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.lZw.getPageContext().getPageActivity(), str3, str2, a.this.lZw.dnP(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    };
    public final View.OnClickListener lZx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(R.id.tag_user_id) instanceof String) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), a.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 2));
            }
        }
    };
    public final View.OnClickListener lZy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                String str = null;
                if (view.getTag() != null) {
                    str = (String) view.getTag();
                }
                if (str != null) {
                    be.bwv().b(a.this.lZw.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(a.this.lZw.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
            }
        }
    };
    public final TbRichTextView.h lZz = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.b.a.4
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(a.this.lZw.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };

    public a(com.baidu.tieba.pb.pb.a aVar) {
        this.lZw = aVar;
    }
}
