package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.R;
import com.baidu.tieba.l.g;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String nsH = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String nsI = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String nsJ = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private f fIC;
    private SpanGroupManager mSpanGroupManager;
    private ErrorData nsK;
    private AntiData nsL;
    private com.baidu.tieba.tbadkCore.videoupload.a nsM;
    private InterfaceC0885a nsN;
    private g nsO;
    private String nsP;
    private z mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0885a {
        void KU(int i);
    }

    public a() {
        this.nsK = null;
        this.nsK = new ErrorData();
    }

    public void a(g gVar) {
        this.nsO = gVar;
    }

    public void a(InterfaceC0885a interfaceC0885a) {
        this.nsN = interfaceC0885a;
    }

    public ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.fIC == null) {
            this.fIC = new f("HTTPWriteService.postImageData");
        }
        return this.fIC.d(imageFileInfo, z);
    }

    public String a(final WriteData writeData, boolean z) {
        String content;
        boolean z2;
        String str;
        String title;
        String str2;
        if (writeData == null) {
            return null;
        }
        b.d("发帖：postWriteData 开始");
        this.mNetwork = new z();
        this.mNetwork.bvR().bwA().mIsNeedTbs = true;
        this.mNetwork.jM(true);
        this.mNetwork.addPostData("authsid", writeData.getAuthSid());
        if (!TextUtils.isEmpty(this.nsP)) {
            content = this.nsP;
            writeData.setSpanGroupString(content);
        } else if (this.mSpanGroupManager != null) {
            content = this.mSpanGroupManager.byC();
            writeData.setSpanGroupString(content);
        } else if (!TextUtils.isEmpty(writeData.getSpanGroupString())) {
            content = writeData.getSpanGroupString();
        } else {
            content = writeData.getContent();
        }
        if (writeData.getSubPbReplyPrefix() != null) {
            content = writeData.getSubPbReplyPrefix() + content;
        }
        String str3 = !TextUtils.isEmpty(writeData.getZhongcePrefix()) ? writeData.getZhongcePrefix() + content : content;
        b.d("发帖：发帖类型：" + writeData.getType());
        if (writeData.getType() == 3) {
            b.d("发帖：SHARE_SDK：设置数据");
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.mNetwork.addPostData("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.mNetwork.addPostData("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            }
            this.mNetwork.addPostData("newVcode", "1");
            this.mNetwork.addPostData("content", str3);
            this.mNetwork.setUrl(nsJ);
            this.mNetwork.addPostData("fname", writeData.getForumName());
            if (!TextUtils.isEmpty(writeData.getTitle())) {
                this.mNetwork.addPostData("title", writeData.getTitle());
            }
            if (!StringUtils.isNull(writeData.getPostPrefix())) {
                this.mNetwork.addPostData("post_prefix", writeData.getPostPrefix());
            }
            this.mNetwork.addPostData("apiKey", writeData.getShareApiKey());
            this.mNetwork.addPostData("appName", writeData.getShareAppName());
            this.mNetwork.addPostData("signKey", writeData.getShareSignKey());
            this.mNetwork.addPostData("summary_title", writeData.getShareSummaryTitle());
            this.mNetwork.addPostData("summary_content", writeData.getShareSummaryContent());
            this.mNetwork.addPostData("summary_img", writeData.getShareSummaryImg());
            this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.mNetwork.addPostData("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            b.d("发帖：开始分段数据发送");
            if (z && writeData.isHasImages()) {
                b.d("发帖：发送图片 开始");
                if (this.fIC == null) {
                    this.fIC = new f("HTTPWriteService.postWriteData");
                    this.fIC.a(new f.b() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                        @Override // com.baidu.tbadk.img.f.b
                        public void a(String str4, Object obj, long j, long j2, int i, int i2) {
                            b.d("发帖：发送图片 进度 = " + i + "/" + i2 + " :" + j + "/" + j2 + "   ，" + str4);
                            int i3 = (int) (90.0f / i2);
                            float f = (((float) j) / 2.0f) / ((float) j2);
                            if (f > 1.0f) {
                                f = 1.0f;
                            }
                            bg.a(writeData, (int) (((f + i) - 1.0f) * i3)).jw(true);
                        }
                    }, writeData);
                }
                if (writeData.getType() == 6) {
                    b.d("发帖：发送图片 上传图片 开始 1");
                    if (this.fIC.b(writeData.getWriteImagesInfo(), true) != null) {
                        this.nsK.setError_code(-53);
                        this.nsK.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        b.d("发帖：发送图片 上传图片 错误 1");
                        return null;
                    }
                    b.d("发帖：发送图片 上传图片 完成 1");
                } else {
                    b.d("发帖：发送图片 上传图片 开始 2");
                    this.fIC.fJc = writeData.isBJHPost();
                    ErrorData b2 = this.fIC.b(writeData.getWriteImagesInfo(), true);
                    if (b2 != null) {
                        this.nsK.setError_code(-53);
                        this.nsK.setError_msg(b2.getError_msg());
                        b.d("发帖：发送图片 上传图片 错误 2");
                        return null;
                    }
                    b.d("发帖：发送图片 上传图片 完成 2");
                }
            }
            if (this.isCancelled) {
                return null;
            }
            String voice = writeData.getVoice();
            String str4 = null;
            int voiceDuringTime = writeData.getVoiceDuringTime();
            if (writeData.getReturnVoiceMd5() == null) {
                z2 = false;
            } else {
                z2 = true;
                str4 = writeData.getReturnVoiceMd5();
            }
            b.d("声音文件 = " + voice);
            if (voice != null && !z2) {
                b.d("发帖：发送声音 开始");
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                bVar.addPostParam("type", 1);
                String storeFile = n.getStoreFile(voice, 1);
                q CJ = bVar.CJ(storeFile);
                if (CJ != null && CJ.isSuccess()) {
                    p bzT = CJ.bzT();
                    if (bzT != null) {
                        str4 = bzT.getMd5();
                        com.baidu.tbadk.core.voice.a.b.renameFile(writeData.getVoice(), str4);
                        writeData.setReturnVoiceMd5(str4);
                        b.d("发帖：发送声音 完成 1");
                    } else {
                        m mVar = new m();
                        mVar.append("ErrCode", Integer.valueOf(CJ.getErrorCode()));
                        mVar.append("ErrMsg", CJ.getErrorString());
                        TiebaStatic.voiceError(-1113, "audioUploadData is null", mVar.toString());
                        this.nsK.setError_code(CJ.getErrorCode());
                        this.nsK.setError_msg(CJ.getErrorString());
                        b.d("发帖：发送声音 失败 1");
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.append("audioFile", storeFile);
                    TiebaStatic.voiceError(-1113, "uploadService.upload null or fail", mVar2.toString());
                    if (CJ != null) {
                        this.nsK.setError_code(CJ.getErrorCode());
                        this.nsK.setError_msg(CJ.getErrorString());
                    }
                    b.d("发帖：发送声音 失败 2");
                    return null;
                }
            }
            if (this.isCancelled) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.nsM = new com.baidu.tieba.tbadkCore.videoupload.a(this.nsO);
                    b.d("发帖：开始上传视频");
                    VideoFinishResult a2 = this.nsM.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new e() { // from class: com.baidu.tieba.tbadkCore.c.a.2
                        int nsR = 0;

                        @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                        public void aX(float f) {
                            b.d("发帖：开始上传视频 percent = " + f);
                            int i = (int) (90.0f * f);
                            bg.a(writeData, i).jw(true);
                            if (i != this.nsR) {
                                this.nsR = i;
                                a.this.KT(i);
                            }
                        }
                    });
                    if (a2 == null) {
                        this.nsK.setError_code(-53);
                        this.nsK.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        b.d("发帖：开始上传视频 失败 1");
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                        b.d("发帖：开始上传视频 成功 ");
                    } else {
                        this.nsK.setError_code(a2.getErrorNo());
                        this.nsK.setError_msg(a2.getUserMessage());
                        b.d("发帖：开始上传视频 失败 2");
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    b.d("发帖：开始上传首帧图 开始 ");
                    if (this.fIC == null) {
                        this.fIC = new f("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult ay = this.fIC.ay(videoInfo.getThumbPath(), false);
                    if (ay != null) {
                        videoInfo.setThumbId(ay.picId);
                        if (ay.picInfo != null && ay.picInfo.bigPic != null && !StringUtils.isNull(ay.picInfo.bigPic.picUrl)) {
                            com.baidu.tieba.tbadkCore.writeModel.a.dQB().TR(ay.picInfo.bigPic.picUrl);
                        }
                    }
                    b.d("发帖：开始上传首帧图 完成 ");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!x.isEmpty(videoInfo.getStickListInfo())) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str5 : videoInfo.getStickListInfo()) {
                            jSONArray.put(str5);
                        }
                        jSONObject.put(AlaLiveStickerInfo.STICKER_ID, jSONArray);
                    }
                    if (!x.isEmpty(videoInfo.getBeautifyListInfo())) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (String str6 : videoInfo.getBeautifyListInfo()) {
                            jSONArray2.put(str6);
                        }
                        jSONObject.put("beautify_level", jSONArray2);
                    }
                    if (!x.isEmpty(videoInfo.getFilterListInfo())) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (String str7 : videoInfo.getFilterListInfo()) {
                            jSONArray3.put(str7);
                        }
                        jSONObject.put("filter_id", jSONArray3);
                    }
                    if (!x.isEmpty(videoInfo.getMusicListInfo())) {
                        JSONArray jSONArray4 = new JSONArray();
                        for (String str8 : videoInfo.getMusicListInfo()) {
                            jSONArray4.put(str8);
                        }
                        jSONObject.put("music_id", jSONArray4);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.mNetwork.addPostData("video_other", jSONObject.toString());
            }
            b.d("发帖：上传视频结束 完全完成 ");
            if (this.isCancelled) {
                return null;
            }
            b.d("发帖：其他数据设置开始 ");
            this.mNetwork.addPostData("anonymous", "1");
            this.mNetwork.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
            this.mNetwork.addPostData("is_feedback", writeData.isUserFeedback() ? "1" : "0");
            this.mNetwork.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
            this.mNetwork.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
            if (str4 != null) {
                this.mNetwork.addPostData("voice_md5", str4);
                this.mNetwork.addPostData("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6) {
                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str3) && writeData.getVideoInfo() == null) {
                    this.nsK.setError_code(-53);
                    this.nsK.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                    return null;
                }
                if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str3) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                    this.nsK.setError_code(-53);
                    this.nsK.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                    return null;
                }
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.mNetwork.addPostData("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.mNetwork.addPostData("vcode_md5", writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.mNetwork.addPostData("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.mNetwork.addPostData("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            Address address = com.baidu.adp.lib.c.a.lI().getAddress(false);
            if (!TextUtils.isEmpty(writeData.getTopicId())) {
                this.mNetwork.addPostData("topic_id", writeData.getTopicId());
            }
            this.mNetwork.addPostData("new_vcode", "1");
            String str9 = null;
            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                str = str3 + imagesCodeForPost;
                title = writeData.getTitle();
            } else {
                String buildContent = writeData.getVideoInfo().buildContent();
                title = writeData.getTitle();
                str = buildContent + imagesCodeForPost;
                str9 = str3 + imagesCodeForPost;
                writeData.setIsNoTitle(at.isEmpty(title));
            }
            String voteContentForPost = writeData.getVoteContentForPost();
            if (!StringUtils.isNull(voteContentForPost)) {
                str = str + voteContentForPost;
            }
            j.BI(str);
            String JR = com.baidu.tieba.face.a.JR(str);
            if (!TextUtils.isEmpty(str9)) {
                str9 = com.baidu.tieba.face.a.JR(str9);
            }
            this.mNetwork.addPostData("content", JR);
            this.mNetwork.addPostData("reply_uid", writeData.getReplyId());
            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                this.mNetwork.addPostData("meme_text", writeData.getMemeText());
            }
            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                this.mNetwork.addPostData("meme_cont_sign", writeData.getMemeContSign());
            }
            if (!TextUtils.isEmpty(writeData.getItem_id())) {
                this.mNetwork.addPostData(LegoListActivityConfig.ITEM_ID, writeData.getItem_id());
            }
            if (!TextUtils.isEmpty(writeData.getComment_head())) {
                this.mNetwork.addPostData("comment_head", writeData.getComment_head());
            }
            b.d("设置数据");
            switch (writeData.getType()) {
                case 0:
                case 7:
                case 9:
                    this.mNetwork.setUrl(nsH);
                    if (writeData.isCanNoForum()) {
                        this.mNetwork.addPostData("fid", "0");
                        this.mNetwork.addPostData("kw", "");
                        this.mNetwork.addPostData("transform_forums", writeData.getTransmitForumData());
                    } else {
                        this.mNetwork.addPostData("fid", writeData.getForumId());
                        this.mNetwork.addPostData("kw", writeData.getForumName());
                    }
                    this.mNetwork.addPostData("is_hide", writeData.isPrivacy() ? "1" : "0");
                    this.mNetwork.addPostData("is_repost_to_dynamic", writeData.isToDynamic() ? "1" : "0");
                    if (writeData.getVideoId() != null) {
                        this.mNetwork.addPostData("video_id", writeData.getVideoId());
                        if (writeData.getOriginalVideoCover() != null) {
                            this.mNetwork.addPostData("origin_video_cover", writeData.getOriginalVideoCover());
                        }
                        if (writeData.getOriginalVideoTitle() != null) {
                            this.mNetwork.addPostData("origin_video_title", writeData.getOriginalVideoTitle());
                        }
                    }
                    if (writeData.isShareThread()) {
                        this.mNetwork.addPostData("is_share", "1");
                        this.mNetwork.addPostData("from_tid", writeData.getOriginalThreadId());
                    }
                    if (writeData.getProZone() >= 0) {
                        this.mNetwork.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(writeData.getProZone()));
                    }
                    this.mNetwork.addPostData("call_from", writeData.getStatisticFrom() + "");
                    if (!TextUtils.isEmpty(title)) {
                        this.mNetwork.addPostData("title", title);
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        this.mNetwork.addPostData("video_abstract", str9);
                    }
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.addPostData("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.mNetwork.addPostData("st_type", "notitle");
                    }
                    if (address != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + "," + String.valueOf(address.getLongitude()));
                    }
                    com.baidu.tieba.tbadkCore.writeModel.g.a(this.mNetwork, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.mNetwork.addPostData("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.mNetwork.addPostData("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                    }
                    if (writeData.getType() == 7) {
                        this.mNetwork.addPostData("is_bottle", String.valueOf(1));
                    }
                    if (writeData.getRecommendExt() != null) {
                        this.mNetwork.addPostData("recommend_ext", writeData.getRecommendExt());
                    }
                    if (writeData.isLinkThread()) {
                        this.mNetwork.addPostData("link_url", writeData.getLinkUrl());
                        this.mNetwork.addPostData("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                    }
                    this.mNetwork.addPostData("is_link_thread", writeData.isLinkThread() ? "1" : "0");
                    if (writeData.isShareThread()) {
                        if (writeData.getOriBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", writeData.getOriBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_vid", writeData.getOriBaijiahaoData().oriUgcVid);
                            this.mNetwork.addPostData("ori_ugc_tid", writeData.getOriBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(writeData.getOriBaijiahaoData().oriUgcType));
                        }
                    } else if (writeData.getBaijiahaoData() != null) {
                        this.mNetwork.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.mNetwork.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        this.mNetwork.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.mNetwork.addPostData("ori_ugc_type", String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                    }
                    if (writeData.getTabId() > 0) {
                        this.mNetwork.addPostData("tab_name", writeData.getTabName());
                        this.mNetwork.addPostData("tab_id", String.valueOf(writeData.getTabId()));
                        this.mNetwork.addPostData("is_general_tab", String.valueOf(writeData.getIsGeneralTab()));
                    }
                    this.mNetwork.addPostData("is_forum_business_account", writeData.isForumBusinessAccount ? "1" : "0");
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.mNetwork.setUrl(nsI);
                    this.mNetwork.addPostData("fid", writeData.getForumId());
                    this.mNetwork.addPostData("from_fourm_id", writeData.getFromForumId());
                    this.mNetwork.addPostData("v_fid", writeData.getVForumId());
                    this.mNetwork.addPostData("v_fname", writeData.getVForumName());
                    this.mNetwork.addPostData("tid", writeData.getThreadId());
                    this.mNetwork.addPostData("kw", writeData.getForumName());
                    this.mNetwork.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.mNetwork.addPostData("is_barrage", writeData.isBarrage() ? "1" : "0");
                    this.mNetwork.addPostData("barrage_time", String.valueOf(writeData.getBarrageTime()));
                    if (writeData.isFrsReply()) {
                        this.mNetwork.addPostData("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.pb.a.bFm().getStatus() == 1) {
                        this.mNetwork.addPostData("ptype", "4");
                    }
                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                        this.mNetwork.addPostData("post_from", writeData.sourceFrom);
                    }
                    if (writeData.getBaijiahaoData() != null) {
                        this.mNetwork.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.mNetwork.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.mNetwork.addPostData("ori_ugc_type", String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.mNetwork.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.g.a(this.mNetwork, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.mNetwork.setUrl(nsI);
                    this.mNetwork.addPostData("fid", writeData.getForumId());
                    this.mNetwork.addPostData("from_fourm_id", writeData.getFromForumId());
                    this.mNetwork.addPostData("v_fid", writeData.getVForumId());
                    this.mNetwork.addPostData("v_fname", writeData.getVForumName());
                    this.mNetwork.addPostData("tid", writeData.getThreadId());
                    this.mNetwork.addPostData("kw", writeData.getForumName());
                    this.mNetwork.addPostData("quote_id", String.valueOf(writeData.getFloor()));
                    this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(0));
                    this.mNetwork.addPostData("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.mNetwork.addPostData("repostid", writeData.getRepostId());
                    }
                    this.mNetwork.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.mNetwork.addPostData("is_addition", writeData.isAddition() ? "1" : "0");
                    this.mNetwork.addPostData("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.mNetwork.addPostData("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.mNetwork.addPostData("st_type", "conadd");
                    }
                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                        this.mNetwork.addPostData("post_from", writeData.sourceFrom);
                    }
                    if (writeData.getBaijiahaoData() != null) {
                        this.mNetwork.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.mNetwork.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.mNetwork.addPostData("ori_ugc_type", String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.mNetwork.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 3:
                case 8:
                default:
                    if (writeData.isCanNoForum()) {
                        this.mNetwork.addPostData("fid", "0");
                        this.mNetwork.addPostData("kw", "");
                        this.mNetwork.addPostData("transform_forums", writeData.getTransmitForumData());
                        str2 = imagesCodeForPost;
                        break;
                    } else {
                        this.mNetwork.addPostData("fid", writeData.getForumId());
                        this.mNetwork.addPostData("kw", writeData.getForumName());
                        str2 = imagesCodeForPost;
                        break;
                    }
                case 4:
                    this.mNetwork.setUrl(nsH);
                    this.mNetwork.addPostData("fid", writeData.getForumId());
                    this.mNetwork.addPostData("kw", writeData.getForumName());
                    if (!TextUtils.isEmpty(writeData.getTitle())) {
                        this.mNetwork.addPostData("title", writeData.getTitle());
                    }
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.addPostData("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.addPostData("thread_type", "33");
                    com.baidu.tieba.tbadkCore.writeModel.g.a(this.mNetwork, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.mNetwork.setUrl(nsI);
                    this.mNetwork.addPostData("fid", writeData.getForumId());
                    this.mNetwork.addPostData("tid", writeData.getThreadId());
                    this.mNetwork.addPostData("kw", writeData.getForumName());
                    this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                    if (writeData.getBaijiahaoData() != null) {
                        this.mNetwork.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                        this.mNetwork.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                        this.mNetwork.addPostData("ori_ugc_type", String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                        this.mNetwork.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.g.a(this.mNetwork, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.mNetwork.setUrl(nsH);
                    this.mNetwork.addPostData("fid", writeData.getForumId());
                    this.mNetwork.addPostData("kw", writeData.getForumName());
                    this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    if (!TextUtils.isEmpty(writeData.getTitle())) {
                        this.mNetwork.addPostData("title", writeData.getTitle());
                    }
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.addPostData("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.mNetwork.addPostData("st_type", "notitle");
                    }
                    com.baidu.tieba.tbadkCore.writeModel.g.a(this.mNetwork, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        if (writeData.isPostLatLng()) {
            String lat = writeData.getLat() == null ? "" : writeData.getLat();
            String lng = writeData.getLng() == null ? "" : writeData.getLng();
            this.mNetwork.addPostData("real_lat", lat);
            this.mNetwork.addPostData("real_lng", lng);
        }
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
        }
        b.d("发帖：其他数据设置开始 发送");
        bg.a(writeData, 93).jw(true);
        String postNetData = this.mNetwork.postNetData();
        b.d("发帖：其他数据设置开始 结束 进度到 95");
        bg.a(writeData, 95).jw(true);
        KT(95);
        if (this.mNetwork.bvR().bwB().isRequestSuccess()) {
            this.nsK.parserJson(postNetData);
        } else {
            this.nsK.setError_code(this.mNetwork.isNetSuccess() ? this.mNetwork.getServerErrorCode() : this.mNetwork.getNetErrorCode());
            this.nsK.setError_msg(this.mNetwork.getErrorString());
        }
        if (this.nsK.error_code != 0 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.nsK.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
        } else if (this.nsK.error_code != 0 && writeData.isHasImages() && k.isEmpty(str3 + str2)) {
            this.nsK.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
        }
        try {
            this.nsL = new AntiData();
            this.nsL.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
        } catch (Exception e2) {
        }
        if (this.nsL.getBlock_stat() == 0 && this.nsK.error_code == 0 && this.mNetwork.bvR() != null && this.mNetwork.bvR().bwA() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.bvR().bwA().bwE()));
        }
        KT(100);
        b.d("发帖：处理整个 发帖过程 结束数据 完成 进度到 100");
        return postNetData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KT(int i) {
        if (this.nsN != null) {
            this.nsN.KU(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.bvR().bwB().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.cancelNetConnect();
        }
        if (this.fIC != null) {
            this.fIC.cancel();
        }
        if (this.nsM != null) {
            this.nsM.cancelUpload();
        }
    }

    public AntiData dPt() {
        return this.nsL;
    }

    public ErrorData dPu() {
        return this.nsK;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Tq(String str) {
        this.nsP = str;
    }
}
