package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.service.b;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String kjv = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String kjw = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String kjx = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private f dAY;
    private com.baidu.tieba.tbadkCore.videoupload.a kjA;
    private InterfaceC0612a kjB;
    private h kjC;
    private ErrorData kjy;
    private AntiData kjz;
    private x mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0612a {
        void CG(int i);
    }

    public a() {
        this.kjy = null;
        this.kjy = new ErrorData();
    }

    public void a(h hVar) {
        this.kjC = hVar;
    }

    public void a(InterfaceC0612a interfaceC0612a) {
        this.kjB = interfaceC0612a;
    }

    public ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.dAY == null) {
            this.dAY = new f("HTTPWriteService.postImageData");
        }
        return this.dAY.d(imageFileInfo, z);
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
        this.mNetwork.aGk().aGL().mIsNeedTbs = true;
        this.mNetwork.fL(true);
        this.mNetwork.addPostData("authsid", writeData.getAuthSid());
        if (writeData.getSubPbReplyPrefix() != null) {
            content = writeData.getSubPbReplyPrefix() + writeData.getContent();
        } else {
            content = writeData.getContent();
        }
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.mNetwork.addPostData("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.mNetwork.addPostData("tag", "11");
            }
            this.mNetwork.addPostData("newVcode", "1");
            this.mNetwork.addPostData("content", content);
            this.mNetwork.setUrl(kjx);
            this.mNetwork.addPostData("fname", writeData.getForumName());
            this.mNetwork.addPostData("title", writeData.getTitle());
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
            str3 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.dAY == null) {
                    this.dAY = new f("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (this.dAY.b(writeData.getWriteImagesInfo(), true) != null) {
                        this.kjy.setError_code(-53);
                        this.kjy.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        return null;
                    }
                } else {
                    this.dAY.dBt = writeData.isBJHPost();
                    ErrorData b = this.dAY.b(writeData.getWriteImagesInfo(), true);
                    if (b != null) {
                        this.kjy.setError_code(-53);
                        this.kjy.setError_msg(b.getError_msg());
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
                String storeFile = m.getStoreFile(voice, 1);
                com.baidu.tbadk.coreExtra.data.m ue = bVar.ue(storeFile);
                if (ue != null && ue.isSuccess()) {
                    l aJx = ue.aJx();
                    if (aJx != null) {
                        String md5 = aJx.getMd5();
                        com.baidu.tbadk.core.voice.a.b.renameFile(writeData.getVoice(), md5);
                        writeData.setReturnVoiceMd5(md5);
                        str = md5;
                    } else {
                        com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                        lVar.append("ErrCode", Integer.valueOf(ue.getErrorCode()));
                        lVar.append("ErrMsg", ue.getErrorString());
                        TiebaStatic.voiceError(-1113, "audioUploadData is null", lVar.toString());
                        this.kjy.setError_code(ue.getErrorCode());
                        this.kjy.setError_msg(ue.getErrorString());
                        return null;
                    }
                } else {
                    com.baidu.tbadk.core.util.l lVar2 = new com.baidu.tbadk.core.util.l();
                    lVar2.append("audioFile", storeFile);
                    TiebaStatic.voiceError(-1113, "uploadService.upload null or fail", lVar2.toString());
                    if (ue != null) {
                        this.kjy.setError_code(ue.getErrorCode());
                        this.kjy.setError_msg(ue.getErrorString());
                    }
                    return null;
                }
            }
            if (this.isCancelled) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.kjA = new com.baidu.tieba.tbadkCore.videoupload.a(this.kjC);
                    VideoFinishResult a = this.kjA.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new e() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                        int kjD = 0;

                        @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                        public void aK(float f) {
                            int i = (int) (90.0f * f);
                            if (i != this.kjD) {
                                this.kjD = i;
                                a.this.CF(i);
                            }
                        }
                    });
                    if (a == null) {
                        this.kjy.setError_code(-53);
                        this.kjy.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        return null;
                    } else if (a.isSuccess()) {
                        videoInfo.setVideoMd5(a.getVideoMd5());
                        videoInfo.setVideoUrl(a.getVideoUrl());
                    } else {
                        this.kjy.setError_code(a.getErrorNo());
                        this.kjy.setError_msg(a.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.dAY == null) {
                        this.dAY = new f("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult U = this.dAY.U(videoInfo.getThumbPath(), false);
                    if (U != null) {
                        videoInfo.setThumbId(U.picId);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!v.isEmpty(videoInfo.getStickListInfo())) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str4 : videoInfo.getStickListInfo()) {
                            jSONArray.put(str4);
                        }
                        jSONObject.put("sticker_id", jSONArray);
                    }
                    if (!v.isEmpty(videoInfo.getBeautifyListInfo())) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (String str5 : videoInfo.getBeautifyListInfo()) {
                            jSONArray2.put(str5);
                        }
                        jSONObject.put("beautify_level", jSONArray2);
                    }
                    if (!v.isEmpty(videoInfo.getFilterListInfo())) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (String str6 : videoInfo.getFilterListInfo()) {
                            jSONArray3.put(str6);
                        }
                        jSONObject.put("filter_id", jSONArray3);
                    }
                    if (!v.isEmpty(videoInfo.getMusicListInfo())) {
                        JSONArray jSONArray4 = new JSONArray();
                        for (String str7 : videoInfo.getMusicListInfo()) {
                            jSONArray4.put(str7);
                        }
                        jSONObject.put("music_id", jSONArray4);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.mNetwork.addPostData("video_other", jSONObject.toString());
            }
            if (this.isCancelled) {
                return null;
            }
            this.mNetwork.addPostData("anonymous", "1");
            this.mNetwork.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
            this.mNetwork.addPostData("is_feedback", writeData.isUserFeedback() ? "1" : "0");
            this.mNetwork.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
            this.mNetwork.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
            if (str != null) {
                this.mNetwork.addPostData("voice_md5", str);
                this.mNetwork.addPostData("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6) {
                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(content) && writeData.getVideoInfo() == null) {
                    this.kjy.setError_code(-53);
                    this.kjy.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                    return null;
                }
                if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(content) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread()) {
                    this.kjy.setError_code(-53);
                    this.kjy.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
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
                this.mNetwork.addPostData("vcode_tag", "12");
            }
            Address address = com.baidu.adp.lib.c.a.fK().getAddress(false);
            if (!TextUtils.isEmpty(writeData.getTopicId())) {
                this.mNetwork.addPostData("topic_id", writeData.getTopicId());
            }
            this.mNetwork.addPostData("new_vcode", "1");
            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                str2 = content + imagesCodeForPost;
            } else {
                str2 = content + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
            }
            j.tg(str2);
            this.mNetwork.addPostData("content", com.baidu.tieba.face.a.As(str2));
            this.mNetwork.addPostData("reply_uid", writeData.getReplyId());
            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                this.mNetwork.addPostData("meme_text", writeData.getMemeText());
            }
            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                this.mNetwork.addPostData("meme_cont_sign", writeData.getMemeContSign());
            }
            switch (writeData.getType()) {
                case 0:
                case 7:
                case 9:
                    this.mNetwork.setUrl(kjv);
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
                        this.mNetwork.addPostData("pro_zone", String.valueOf(writeData.getProZone()));
                    }
                    this.mNetwork.addPostData("call_from", writeData.getCallFrom());
                    this.mNetwork.addPostData("title", writeData.getTitle());
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.addPostData("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.mNetwork.addPostData("st_type", "notitle");
                    }
                    if (address != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
                    }
                    c.a(this.mNetwork, writeData);
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
                        str3 = imagesCodeForPost;
                        break;
                    }
                    str3 = imagesCodeForPost;
                    break;
                case 1:
                    this.mNetwork.setUrl(kjw);
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
                    if (com.baidu.tbadk.editortools.pb.a.aOU().getStatus() == 1) {
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
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 2:
                    this.mNetwork.setUrl(kjw);
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
                    this.mNetwork.addPostData(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
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
                        str3 = imagesCodeForPost;
                        break;
                    }
                    str3 = imagesCodeForPost;
                    break;
                case 3:
                case 8:
                default:
                    if (writeData.isCanNoForum()) {
                        this.mNetwork.addPostData("fid", "0");
                        this.mNetwork.addPostData("kw", "");
                        this.mNetwork.addPostData("transform_forums", writeData.getTransmitForumData());
                        str3 = imagesCodeForPost;
                        break;
                    } else {
                        this.mNetwork.addPostData("fid", writeData.getForumId());
                        this.mNetwork.addPostData("kw", writeData.getForumName());
                        str3 = imagesCodeForPost;
                        break;
                    }
                case 4:
                    this.mNetwork.setUrl(kjv);
                    this.mNetwork.addPostData("fid", writeData.getForumId());
                    this.mNetwork.addPostData("kw", writeData.getForumName());
                    this.mNetwork.addPostData("title", writeData.getTitle());
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.addPostData("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.addPostData("thread_type", "33");
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 5:
                    this.mNetwork.setUrl(kjw);
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
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 6:
                    this.mNetwork.setUrl(kjv);
                    this.mNetwork.addPostData("fid", writeData.getForumId());
                    this.mNetwork.addPostData("kw", writeData.getForumName());
                    this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    this.mNetwork.addPostData("title", writeData.getTitle());
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.addPostData("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.mNetwork.addPostData("st_type", "notitle");
                    }
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
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
        String postNetData = this.mNetwork.postNetData();
        CF(95);
        if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
            this.kjy.parserJson(postNetData);
        } else {
            this.kjy.setError_code(this.mNetwork.isNetSuccess() ? this.mNetwork.getServerErrorCode() : this.mNetwork.getNetErrorCode());
            this.kjy.setError_msg(this.mNetwork.getErrorString());
        }
        if (this.kjy.error_code != 0 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kjy.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
        } else if (this.kjy.error_code != 0 && writeData.isHasImages() && k.isEmpty(content + str3)) {
            this.kjy.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
        }
        try {
            this.kjz = new AntiData();
            this.kjz.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
        } catch (Exception e2) {
        }
        if (this.kjz.getBlock_stat() == 0 && this.kjy.error_code == 0 && this.mNetwork.aGk() != null && this.mNetwork.aGk().aGL() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.aGk().aGL().aGO()));
        }
        CF(100);
        return postNetData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CF(int i) {
        if (this.kjB != null) {
            this.kjB.CG(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.aGk().aGM().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.cancelNetConnect();
        }
        if (this.dAY != null) {
            this.dAY.cancel();
        }
        if (this.kjA != null) {
            this.kjA.cancelUpload();
        }
    }

    public AntiData cLL() {
        return this.kjz;
    }

    public ErrorData cLM() {
        return this.kjy;
    }
}
