package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.service.b;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String iHo = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String iHp = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String iHq = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private f cmM;
    private AntiData iHr;
    private com.baidu.tieba.tbadkCore.videoupload.a iHs;
    private InterfaceC0308a iHt;
    private h iHu;
    private ErrorData mErrorData;
    private x mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0308a {
        void onUploadProgress(int i);
    }

    public a() {
        this.mErrorData = null;
        this.mErrorData = new ErrorData();
    }

    public void a(h hVar) {
        this.iHu = hVar;
    }

    public void a(InterfaceC0308a interfaceC0308a) {
        this.iHt = interfaceC0308a;
    }

    public ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.cmM == null) {
            this.cmM = new f("HTTPWriteService.postImageData");
        }
        return this.cmM.d(imageFileInfo, z);
    }

    public String a(WriteData writeData, boolean z) {
        String content;
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2;
        String str3;
        if (writeData == null) {
            return null;
        }
        this.mNetwork = new x();
        this.mNetwork.acH().adF().mIsNeedTbs = true;
        this.mNetwork.dB(true);
        this.mNetwork.x("authsid", writeData.getAuthSid());
        if (writeData.getSubPbReplyPrefix() != null) {
            content = writeData.getSubPbReplyPrefix() + writeData.getContent();
        } else {
            content = writeData.getContent();
        }
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.mNetwork.x("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.mNetwork.x("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            }
            this.mNetwork.x("newVcode", "1");
            this.mNetwork.x("content", content);
            this.mNetwork.setUrl(iHq);
            this.mNetwork.x(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.mNetwork.x("title", writeData.getTitle());
            if (!StringUtils.isNull(writeData.getPostPrefix())) {
                this.mNetwork.x("post_prefix", writeData.getPostPrefix());
            }
            this.mNetwork.x("apiKey", writeData.getShareApiKey());
            this.mNetwork.x("appName", writeData.getShareAppName());
            this.mNetwork.x("signKey", writeData.getShareSignKey());
            this.mNetwork.x("summary_title", writeData.getShareSummaryTitle());
            this.mNetwork.x("summary_content", writeData.getShareSummaryContent());
            this.mNetwork.x("summary_img", writeData.getShareSummaryImg());
            this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.mNetwork.x("referUrl", writeData.getShareReferUrl());
            str3 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.cmM == null) {
                    this.cmM = new f("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (this.cmM.b(writeData.getWriteImagesInfo(), true) != null) {
                        this.mErrorData.setError_code(-53);
                        this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.upload_error));
                        return null;
                    }
                } else {
                    ErrorData b = this.cmM.b(writeData.getWriteImagesInfo(), true);
                    if (b != null) {
                        this.mErrorData.setError_code(-53);
                        this.mErrorData.setError_msg(b.getError_msg());
                        return null;
                    }
                }
            }
            if (this.isCancelled) {
                return null;
            }
            String voice = writeData.getVoice();
            int voiceDuringTime = writeData.getVoiceDuringTime();
            if (writeData.getReturnVoiceMd5() == null) {
                returnVoiceMd5 = null;
                z2 = false;
            } else {
                returnVoiceMd5 = writeData.getReturnVoiceMd5();
                z2 = true;
            }
            if (voice == null || z2) {
                str = returnVoiceMd5;
            } else {
                b bVar = new b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                bVar.addPostParam("type", 1);
                String S = m.S(voice, 1);
                l ny = bVar.ny(S);
                if (ny != null && ny.isSuccess()) {
                    k agp = ny.agp();
                    if (agp != null) {
                        String agn = agp.agn();
                        com.baidu.tbadk.core.voice.a.b.renameFile(writeData.getVoice(), agn);
                        writeData.setReturnVoiceMd5(agn);
                        str = agn;
                    } else {
                        com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                        lVar.l("ErrCode", Integer.valueOf(ny.getErrorCode()));
                        lVar.l("ErrMsg", ny.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.mErrorData.setError_code(ny.getErrorCode());
                        this.mErrorData.setError_msg(ny.getErrorString());
                        return null;
                    }
                } else {
                    com.baidu.tbadk.core.util.l lVar2 = new com.baidu.tbadk.core.util.l();
                    lVar2.l("audioFile", S);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.mErrorData.setError_code(ny.getErrorCode());
                    this.mErrorData.setError_msg(ny.getErrorString());
                    return null;
                }
            }
            if (this.isCancelled) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.iHs = new com.baidu.tieba.tbadkCore.videoupload.a(this.iHu);
                    VideoFinishResult a = this.iHs.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new e() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                        int iHv = 0;

                        @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                        public void aM(float f) {
                            int i = (int) (90.0f * f);
                            if (i != this.iHv) {
                                this.iHv = i;
                                a.this.notifyUploadProgress(i);
                            }
                        }
                    });
                    if (a == null) {
                        this.mErrorData.setError_code(-53);
                        this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.upload_error));
                        return null;
                    } else if (a.isSuccess()) {
                        videoInfo.setVideoMd5(a.getVideoMd5());
                        videoInfo.setVideoUrl(a.getVideoUrl());
                    } else {
                        this.mErrorData.setError_code(a.getErrorNo());
                        this.mErrorData.setError_msg(a.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.cmM == null) {
                        this.cmM = new f("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult P = this.cmM.P(videoInfo.getThumbPath(), false);
                    if (P != null) {
                        videoInfo.setThumbId(P.picId);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!v.T(videoInfo.getStickListInfo())) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str4 : videoInfo.getStickListInfo()) {
                            jSONArray.put(str4);
                        }
                        jSONObject.put("sticker_id", jSONArray);
                    }
                    if (!v.T(videoInfo.getBeautifyListInfo())) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (String str5 : videoInfo.getBeautifyListInfo()) {
                            jSONArray2.put(str5);
                        }
                        jSONObject.put("beautify_level", jSONArray2);
                    }
                    if (!v.T(videoInfo.getFilterListInfo())) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (String str6 : videoInfo.getFilterListInfo()) {
                            jSONArray3.put(str6);
                        }
                        jSONObject.put("filter_id", jSONArray3);
                    }
                    if (!v.T(videoInfo.getMusicListInfo())) {
                        JSONArray jSONArray4 = new JSONArray();
                        for (String str7 : videoInfo.getMusicListInfo()) {
                            jSONArray4.put(str7);
                        }
                        jSONObject.put("music_id", jSONArray4);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.mNetwork.x("video_other", jSONObject.toString());
            }
            if (this.isCancelled) {
                return null;
            }
            this.mNetwork.x("anonymous", "1");
            this.mNetwork.x("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
            this.mNetwork.x("is_feedback", writeData.isUserFeedback() ? "1" : "0");
            this.mNetwork.x("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
            this.mNetwork.x("entrance_type", String.valueOf(writeData.getEntranceType()));
            if (str != null) {
                this.mNetwork.x("voice_md5", str);
                this.mNetwork.x("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6) {
                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(content) && writeData.getVideoInfo() == null) {
                    this.mErrorData.setError_code(-53);
                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.sand_fail));
                    return null;
                }
                if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(content) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread()) {
                    this.mErrorData.setError_code(-53);
                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.sand_fail));
                    return null;
                }
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.mNetwork.x("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.mNetwork.x("vcode_md5", writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.mNetwork.x("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.mNetwork.x("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            Address af = com.baidu.adp.lib.d.a.iW().af(false);
            if (!TextUtils.isEmpty(writeData.getTopicId())) {
                this.mNetwork.x("topic_id", writeData.getTopicId());
            }
            this.mNetwork.x("new_vcode", "1");
            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                str2 = content + imagesCodeForPost;
            } else {
                str2 = content + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
            }
            j.lM(str2);
            this.mNetwork.x("content", com.baidu.tieba.face.a.ue(str2));
            this.mNetwork.x("reply_uid", writeData.getReplyId());
            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                this.mNetwork.x("meme_text", writeData.getMemeText());
            }
            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                this.mNetwork.x("meme_cont_sign", writeData.getMemeContSign());
            }
            switch (writeData.getType()) {
                case 0:
                case 7:
                case 9:
                    this.mNetwork.setUrl(iHo);
                    if (writeData.isCanNoForum()) {
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, "0");
                        this.mNetwork.x("kw", "");
                        this.mNetwork.x("transform_forums", writeData.getTransmitForumData());
                    } else {
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                        this.mNetwork.x("kw", writeData.getForumName());
                    }
                    this.mNetwork.x("is_hide", writeData.isPrivacy() ? "1" : "0");
                    if (writeData.getVideoId() != null) {
                        this.mNetwork.x("video_id", writeData.getVideoId());
                        if (writeData.getOriginalVideoCover() != null) {
                            this.mNetwork.x("origin_video_cover", writeData.getOriginalVideoCover());
                        }
                        if (writeData.getOriginalVideoTitle() != null) {
                            this.mNetwork.x("origin_video_title", writeData.getOriginalVideoTitle());
                        }
                    }
                    if (writeData.isShareThread()) {
                        this.mNetwork.x("is_share", "1");
                        this.mNetwork.x("from_tid", writeData.getOriginalThreadId());
                    }
                    if (writeData.getProZone() >= 0) {
                        this.mNetwork.x("pro_zone", String.valueOf(writeData.getProZone()));
                    }
                    this.mNetwork.x(IntentConfig.CALL_FROM, writeData.getCallFrom());
                    this.mNetwork.x("title", writeData.getTitle());
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.x("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.x("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.mNetwork.x("st_type", "notitle");
                    }
                    if (af != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.mNetwork.x("lbs", String.valueOf(af.getLatitude()) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(af.getLongitude()));
                    }
                    c.a(this.mNetwork, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.mNetwork.x("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.mNetwork.x("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                    }
                    if (writeData.getType() == 7) {
                        this.mNetwork.x("is_bottle", String.valueOf(1));
                    }
                    if (writeData.getRecommendExt() != null) {
                        this.mNetwork.x("recommend_ext", writeData.getRecommendExt());
                    }
                    if (writeData.isLinkThread()) {
                        this.mNetwork.x("link_url", writeData.getLinkUrl());
                        this.mNetwork.x("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                    }
                    this.mNetwork.x("is_link_thread", writeData.isLinkThread() ? "1" : "0");
                    str3 = imagesCodeForPost;
                    break;
                case 1:
                    this.mNetwork.setUrl(iHp);
                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                    this.mNetwork.x("from_fourm_id", writeData.getFromForumId());
                    this.mNetwork.x("v_fid", writeData.getVForumId());
                    this.mNetwork.x("v_fname", writeData.getVForumName());
                    this.mNetwork.x("tid", writeData.getThreadId());
                    this.mNetwork.x("kw", writeData.getForumName());
                    this.mNetwork.x("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.mNetwork.x("is_barrage", writeData.isBarrage() ? "1" : "0");
                    this.mNetwork.x("barrage_time", String.valueOf(writeData.getBarrageTime()));
                    if (writeData.isFrsReply()) {
                        this.mNetwork.x("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.pb.a.amq().getStatus() == 1) {
                        this.mNetwork.x("ptype", "4");
                    }
                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                        this.mNetwork.x("post_from", writeData.sourceFrom);
                    }
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 2:
                    this.mNetwork.setUrl(iHp);
                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                    this.mNetwork.x("from_fourm_id", writeData.getFromForumId());
                    this.mNetwork.x("v_fid", writeData.getVForumId());
                    this.mNetwork.x("v_fname", writeData.getVForumName());
                    this.mNetwork.x("tid", writeData.getThreadId());
                    this.mNetwork.x("kw", writeData.getForumName());
                    this.mNetwork.x("quote_id", String.valueOf(writeData.getFloor()));
                    this.mNetwork.x("is_twzhibo_thread", String.valueOf(0));
                    this.mNetwork.x("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.mNetwork.x("repostid", writeData.getRepostId());
                    }
                    this.mNetwork.x("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.mNetwork.x(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.mNetwork.x("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.mNetwork.x("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.mNetwork.x("st_type", "conadd");
                    }
                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                        this.mNetwork.x("post_from", writeData.sourceFrom);
                        str3 = imagesCodeForPost;
                        break;
                    }
                    str3 = imagesCodeForPost;
                    break;
                case 3:
                case 8:
                default:
                    if (writeData.isCanNoForum()) {
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, "0");
                        this.mNetwork.x("kw", "");
                        this.mNetwork.x("transform_forums", writeData.getTransmitForumData());
                        str3 = imagesCodeForPost;
                        break;
                    } else {
                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                        this.mNetwork.x("kw", writeData.getForumName());
                        str3 = imagesCodeForPost;
                        break;
                    }
                case 4:
                    this.mNetwork.setUrl(iHo);
                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                    this.mNetwork.x("kw", writeData.getForumName());
                    this.mNetwork.x("title", writeData.getTitle());
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.x("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.x("thread_type", "33");
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 5:
                    this.mNetwork.setUrl(iHp);
                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                    this.mNetwork.x("tid", writeData.getThreadId());
                    this.mNetwork.x("kw", writeData.getForumName());
                    this.mNetwork.x("is_twzhibo_thread", String.valueOf(1));
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 6:
                    this.mNetwork.setUrl(iHo);
                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                    this.mNetwork.x("kw", writeData.getForumName());
                    this.mNetwork.x("thread_type", String.valueOf(36));
                    this.mNetwork.x("title", writeData.getTitle());
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.x("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.x("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.mNetwork.x("st_type", "notitle");
                    }
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
                    break;
            }
        }
        if (writeData.isPostLatLng()) {
            String lat = writeData.getLat() == null ? "" : writeData.getLat();
            String lng = writeData.getLng() == null ? "" : writeData.getLng();
            this.mNetwork.x("real_lat", lat);
            this.mNetwork.x("real_lng", lng);
        }
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
        }
        String acj = this.mNetwork.acj();
        notifyUploadProgress(95);
        if (this.mNetwork.acH().adG().isRequestSuccess()) {
            this.mErrorData.parserJson(acj);
        } else {
            this.mErrorData.setError_code(this.mNetwork.acK() ? this.mNetwork.acL() : this.mNetwork.acM());
            this.mErrorData.setError_msg(this.mNetwork.getErrorString());
        }
        if (this.mErrorData.error_code != 0 && !com.baidu.adp.lib.util.j.kY()) {
            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.j.neterror));
        } else if (this.mErrorData.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(content + str3)) {
            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.j.img_upload_error));
        }
        try {
            this.iHr = new AntiData();
            this.iHr.parserJson(new JSONObject(acj).optJSONObject("anti_stat"));
        } catch (Exception e2) {
        }
        if (this.iHr.getBlock_stat() == 0 && this.mErrorData.error_code == 0 && this.mNetwork.acH() != null && this.mNetwork.acH().adF() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.mNetwork.acH().adF().adI()));
        }
        notifyUploadProgress(100);
        return acj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUploadProgress(int i) {
        if (this.iHt != null) {
            this.iHt.onUploadProgress(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.acH().adG().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.ji();
        }
        if (this.cmM != null) {
            this.cmM.cancel();
        }
        if (this.iHs != null) {
            this.iHs.cfu();
        }
    }

    public AntiData ceH() {
        return this.iHr;
    }

    public ErrorData getErrorData() {
        return this.mErrorData;
    }
}
