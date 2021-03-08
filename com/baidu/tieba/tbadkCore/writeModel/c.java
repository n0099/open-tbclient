package com.baidu.tieba.tbadkCore.writeModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ShadowLinearLayout;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class c {
    public static AntiData antiData;
    private static WeakReference<com.baidu.tbadk.core.view.a> nDn;
    public static PostWriteCallBackData nDo;
    public static ah nDp;
    public static WriteData nDq;
    public static Intent nDr;
    private static final BdUniqueId uniqueId = BdUniqueId.gen();

    static {
        dPv();
    }

    public static void k(PostWriteCallBackData postWriteCallBackData) {
        NavigationBarCoverTip navigationBarCoverTip;
        b.d("发帖-成功-视频： 成功弹框 -- start");
        if (postWriteCallBackData != null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                b.d("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                b.d("发帖-成功-视频： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
                return;
            }
            NavigationBarCoverTip navigationBarCoverTip2 = null;
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                    navigationBarCoverTip2 = (NavigationBarCoverTip) frameLayout.getChildAt(i);
                }
            }
            if (navigationBarCoverTip2 == null) {
                NavigationBarCoverTip navigationBarCoverTip3 = new NavigationBarCoverTip(currentActivity);
                frameLayout.addView(navigationBarCoverTip3, new ViewGroup.LayoutParams(-1, -2));
                navigationBarCoverTip = navigationBarCoverTip3;
            } else {
                navigationBarCoverTip = navigationBarCoverTip2;
            }
            navigationBarCoverTip.setVisibility(8);
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout_no_tip, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_video_title));
            ap.setViewTextColor(textView, R.color.CAM_X0302);
            shadowLinearLayout.onChangeSkinType();
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.a(currentActivity, shadowLinearLayout, 5000);
            b.d("发帖-成功-视频： 成功弹框 -- 成功 -- end");
        }
    }

    public static void b(PostWriteCallBackData postWriteCallBackData) {
        final NavigationBarCoverTip navigationBarCoverTip;
        b.d("发帖-成功： 成功弹框 -- start");
        if (postWriteCallBackData != null) {
            final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (j == 0 || j2 == 0) {
                b.d("发帖-成功： 成功弹框 -- 失败 -- postId = " + j + "  threadId = " + j2);
                return;
            }
            final Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                b.d("发帖-成功： 成功弹框 -- 失败 -- 当前Activity为NULL");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
            if (frameLayout == null) {
                b.d("发帖-成功： 成功弹框 -- 失败 -- 当前Activity的content为NULL");
                return;
            }
            NavigationBarCoverTip navigationBarCoverTip2 = null;
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                    navigationBarCoverTip2 = (NavigationBarCoverTip) frameLayout.getChildAt(i);
                }
            }
            if (navigationBarCoverTip2 == null) {
                navigationBarCoverTip = new NavigationBarCoverTip(currentActivity);
                frameLayout.addView(navigationBarCoverTip, new ViewGroup.LayoutParams(-1, -2));
            } else {
                navigationBarCoverTip = navigationBarCoverTip2;
            }
            navigationBarCoverTip.setVisibility(8);
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_content);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.tb_top_toast_btn);
            textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
            textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
            tBSpecificationBtn.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
            ap.setViewTextColor(textView, R.color.CAM_X0302);
            ap.setViewTextColor(textView2, R.color.CAM_X0302);
            tBSpecificationBtn.bus();
            shadowLinearLayout.onChangeSkinType();
            tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.writeModel.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.d("发帖-成功： 开始分享 -- start");
                    view.setOnClickListener(null);
                    if (!j.isNetWorkAvailable()) {
                        l.showToast(currentActivity, R.string.neterror);
                        navigationBarCoverTip.hideTip();
                        b.d("发帖-成功： 开始分享 -- 失败 -- 无网");
                        return;
                    }
                    int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = currentActivity.getResources().getDisplayMetrics().density;
                    int i2 = 1;
                    if (av.bsV().bsW()) {
                        i2 = 2;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(c.uniqueId);
                    requestGetMyPostNetMessage.setParams(j2, j, 0L, equipmentWidth, equipmentHeight, f, i2);
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    b.d("发帖-成功： 开始分享 -- 发送GetMyPost");
                    c.aw(currentActivity);
                    navigationBarCoverTip.hideTip();
                    b.d("发帖-成功： 开始分享 -- 关闭成功弹框");
                }
            });
            navigationBarCoverTip.setBackgroundColor(0);
            navigationBarCoverTip.a(currentActivity, shadowLinearLayout, 5000);
            b.d("发帖-成功： 成功弹框 -- 成功 -- end");
        }
    }

    public static void a(PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData2) {
        NavigationBarCoverTip navigationBarCoverTip;
        if (postWriteCallBackData == null) {
            b.d("发帖-失败： 失败弹框 -- 无backData");
            return;
        }
        nDo = postWriteCallBackData;
        nDp = ahVar;
        nDq = writeData;
        antiData = antiData2;
        b.d("发帖-失败： 失败弹框 -- start");
        final Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            b.d("发帖-失败： 失败弹框 -- 失败 -- 当前Activity为NULL");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) currentActivity.findViewById(16908290);
        if (frameLayout == null) {
            b.d("发帖-失败： 失败弹框 -- 失败 -- 当前Activity的content为NULL");
            return;
        }
        NavigationBarCoverTip navigationBarCoverTip2 = null;
        for (int i = 0; i < frameLayout.getChildCount(); i++) {
            if (frameLayout.getChildAt(i) instanceof NavigationBarCoverTip) {
                navigationBarCoverTip2 = (NavigationBarCoverTip) frameLayout.getChildAt(i);
            }
        }
        if (navigationBarCoverTip2 == null) {
            NavigationBarCoverTip navigationBarCoverTip3 = new NavigationBarCoverTip(currentActivity);
            frameLayout.addView(navigationBarCoverTip3, new ViewGroup.LayoutParams(-1, -2));
            navigationBarCoverTip = navigationBarCoverTip3;
        } else {
            navigationBarCoverTip = navigationBarCoverTip2;
        }
        navigationBarCoverTip.setVisibility(8);
        ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(currentActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
        TextView textView = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
        TextView textView2 = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_content);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) shadowLinearLayout.findViewById(R.id.tb_top_toast_btn);
        textView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_title));
        String errorString = postWriteCallBackData.getErrorString();
        if (TextUtils.isEmpty(errorString)) {
            textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_content));
        } else {
            textView2.setText(errorString);
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_fail_btn));
        tBSpecificationBtn.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        ap.setViewTextColor(textView, R.color.CAM_X0301);
        ap.setViewTextColor(textView2, R.color.CAM_X0301);
        tBSpecificationBtn.bus();
        shadowLinearLayout.onChangeSkinType();
        tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.writeModel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.d("发帖-失败： 重新编辑 -- start");
                view.setOnClickListener(null);
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(currentActivity);
                if (c.nDr != null) {
                    newInstance.setIntent(c.nDr);
                }
                newInstance.setFromErrorDialog(true);
                newInstance.send();
                d.dPz();
                b.d("发帖-失败： 重新编辑 -- end");
            }
        });
        navigationBarCoverTip.setBackgroundColor(0);
        navigationBarCoverTip.a(currentActivity, shadowLinearLayout, 5000);
        d.dPy();
        b.d("发帖-失败： 失败弹框 -- 成功 -- end");
    }

    private static void dPv() {
        com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.tbadkCore.writeModel.c.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                b.d("发帖-成功： 分享进行 -- 接受GetMyPost");
                c.ckD();
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    c.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    c.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        aVar.setTag(uniqueId);
        aVar.getHttpMessageListener().setSelfListener(true);
        aVar.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, GetMyPostResIdl getMyPostResIdl) {
        b.d("发帖-成功： 分享进行 -- 处理GetMyPost");
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            b.d("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- ACT为NULL");
        } else if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            l.showToast(currentActivity, R.string.neterror);
            b.d("发帖-成功： 分享进行 -- 处理GetMyPost -- 失败 -- 请求数据异常");
        } else {
            cb cbVar = new cb();
            cbVar.a(getMyPostResIdl.data.thread_info);
            a(cbVar, currentActivity);
        }
    }

    private static void a(cb cbVar, Activity activity) {
        b.d("发帖-成功： 分享弹框 -- start");
        if (cbVar != null && activity != null) {
            String valueOf = String.valueOf(cbVar.getFid());
            String bnW = cbVar.bnW();
            String title = cbVar.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = cbVar.getAbstract();
            }
            String tid = cbVar.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(cbVar);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = cbVar.getAbstract();
            String format = MessageFormat.format(activity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.fwu = str2;
            shareItem.linkUrl = str;
            shareItem.eVJ = 5;
            shareItem.extData = tid;
            shareItem.fwx = 3;
            shareItem.fid = valueOf;
            shareItem.fName = bnW;
            shareItem.tid = tid;
            shareItem.fwj = true;
            shareItem.fww = 15;
            shareItem.fwB = getStateThreadType(cbVar);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo(cbVar);
            shareItem.fwF = ShareItem.ForwardInfo.generateForwardInfo(cbVar);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fwL = cbVar.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fwx);
            bundle.putInt("obj_type", shareItem.fwB);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eVJ);
            shareItem.ae(bundle);
            b.d("发帖-成功： 分享弹框 -- 显示 -- end");
            com.baidu.tieba.c.f.ctM().b(new ShareDialogConfig((Context) activity, shareItem, true, true));
        }
    }

    private static int getStateThreadType(cb cbVar) {
        if (cbVar != null) {
            if (cbVar.bnU()) {
                return 4;
            }
            if (cbVar.bnP() == 1) {
                return 3;
            }
            return cbVar.bpm() ? 2 : 1;
        }
        return 0;
    }

    private static String getShareImageUrl(cb cbVar) {
        if (cbVar == null || cbVar.bob() == null) {
            return null;
        }
        ArrayList<MediaData> bob = cbVar.bob();
        int size = bob.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bob.get(i);
            if (mediaData != null && mediaData.getType() == 3) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    return mediaData.getThumbnails_url();
                }
                if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    return mediaData.getPicUrl();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aw(Activity activity) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(activity);
        nDn = new WeakReference<>(aVar);
        aVar.setDialogVisiable(true);
        b.d("发帖-成功： 开始分享 -- 显示loading");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ckD() {
        com.baidu.tbadk.core.view.a aVar;
        b.d("发帖-成功： 开始分享 -- 隐藏loading -- start");
        if (nDn != null && (aVar = nDn.get()) != null) {
            aVar.setDialogVisiable(false);
            b.d("发帖-成功： 开始分享 -- 隐藏loading -- end");
            nDn.clear();
        }
    }
}
