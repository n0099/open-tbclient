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
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.core.voice.service.b;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.q;
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
    private static final String mpN = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String mpO = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String mpP = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private f eRB;
    private SpanGroupManager mSpanGroupManager;
    private ErrorData mpQ;
    private AntiData mpR;
    private com.baidu.tieba.tbadkCore.videoupload.a mpS;
    private InterfaceC0804a mpT;
    private h mpU;
    private aa mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0804a {
        void Iv(int i);
    }

    public a() {
        this.mpQ = null;
        this.mpQ = new ErrorData();
    }

    public void a(h hVar) {
        this.mpU = hVar;
    }

    public void a(InterfaceC0804a interfaceC0804a) {
        this.mpT = interfaceC0804a;
    }

    public ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.eRB == null) {
            this.eRB = new f("HTTPWriteService.postImageData");
        }
        return this.eRB.d(imageFileInfo, z);
    }

    public String a(WriteData writeData, boolean z) {
        String content;
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2;
        String title;
        String str3;
        if (writeData == null) {
            return null;
        }
        this.mNetwork = new aa();
        this.mNetwork.bjL().bkq().mIsNeedTbs = true;
        this.mNetwork.ii(true);
        this.mNetwork.addPostData("authsid", writeData.getAuthSid());
        if (this.mSpanGroupManager != null) {
            content = this.mSpanGroupManager.bmp();
            writeData.setSpanGroupString(content);
        } else if (!TextUtils.isEmpty(writeData.getSpanGroupString())) {
            content = writeData.getSpanGroupString();
        } else {
            content = writeData.getContent();
        }
        if (writeData.getSubPbReplyPrefix() != null) {
            content = writeData.getSubPbReplyPrefix() + content;
        }
        String str4 = !TextUtils.isEmpty(writeData.getZhongcePrefix()) ? writeData.getZhongcePrefix() + content : content;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.mNetwork.addPostData("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.mNetwork.addPostData("tag", "11");
            }
            this.mNetwork.addPostData("newVcode", "1");
            this.mNetwork.addPostData("content", str4);
            this.mNetwork.setUrl(mpP);
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
            str3 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.eRB == null) {
                    this.eRB = new f("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (this.eRB.b(writeData.getWriteImagesInfo(), true) != null) {
                        this.mpQ.setError_code(-53);
                        this.mpQ.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        return null;
                    }
                } else {
                    this.eRB.eSa = writeData.isBJHPost();
                    ErrorData b = this.eRB.b(writeData.getWriteImagesInfo(), true);
                    if (b != null) {
                        this.mpQ.setError_code(-53);
                        this.mpQ.setError_msg(b.getError_msg());
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
                String storeFile = n.getStoreFile(voice, 1);
                q Bm = bVar.Bm(storeFile);
                if (Bm != null && Bm.isSuccess()) {
                    p bnF = Bm.bnF();
                    if (bnF != null) {
                        String md5 = bnF.getMd5();
                        com.baidu.tbadk.core.voice.a.b.renameFile(writeData.getVoice(), md5);
                        writeData.setReturnVoiceMd5(md5);
                        str = md5;
                    } else {
                        m mVar = new m();
                        mVar.append("ErrCode", Integer.valueOf(Bm.getErrorCode()));
                        mVar.append("ErrMsg", Bm.getErrorString());
                        TiebaStatic.voiceError(-1113, "audioUploadData is null", mVar.toString());
                        this.mpQ.setError_code(Bm.getErrorCode());
                        this.mpQ.setError_msg(Bm.getErrorString());
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.append("audioFile", storeFile);
                    TiebaStatic.voiceError(-1113, "uploadService.upload null or fail", mVar2.toString());
                    if (Bm != null) {
                        this.mpQ.setError_code(Bm.getErrorCode());
                        this.mpQ.setError_msg(Bm.getErrorString());
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
                    this.mpS = new com.baidu.tieba.tbadkCore.videoupload.a(this.mpU);
                    VideoFinishResult a = this.mpS.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new e() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                        int mpV = 0;

                        @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                        public void aD(float f) {
                            int i = (int) (90.0f * f);
                            if (i != this.mpV) {
                                this.mpV = i;
                                a.this.Iu(i);
                            }
                        }
                    });
                    if (a == null) {
                        this.mpQ.setError_code(-53);
                        this.mpQ.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        return null;
                    } else if (a.isSuccess()) {
                        videoInfo.setVideoMd5(a.getVideoMd5());
                        videoInfo.setVideoUrl(a.getVideoUrl());
                    } else {
                        this.mpQ.setError_code(a.getErrorNo());
                        this.mpQ.setError_msg(a.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.eRB == null) {
                        this.eRB = new f("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult ar = this.eRB.ar(videoInfo.getThumbPath(), false);
                    if (ar != null) {
                        videoInfo.setThumbId(ar.picId);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!y.isEmpty(videoInfo.getStickListInfo())) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str5 : videoInfo.getStickListInfo()) {
                            jSONArray.put(str5);
                        }
                        jSONObject.put(AlaLiveStickerInfo.STICKER_ID, jSONArray);
                    }
                    if (!y.isEmpty(videoInfo.getBeautifyListInfo())) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (String str6 : videoInfo.getBeautifyListInfo()) {
                            jSONArray2.put(str6);
                        }
                        jSONObject.put("beautify_level", jSONArray2);
                    }
                    if (!y.isEmpty(videoInfo.getFilterListInfo())) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (String str7 : videoInfo.getFilterListInfo()) {
                            jSONArray3.put(str7);
                        }
                        jSONObject.put("filter_id", jSONArray3);
                    }
                    if (!y.isEmpty(videoInfo.getMusicListInfo())) {
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
                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str4) && writeData.getVideoInfo() == null) {
                    this.mpQ.setError_code(-53);
                    this.mpQ.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                    return null;
                }
                if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str4) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                    this.mpQ.setError_code(-53);
                    this.mpQ.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
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
            Address address = com.baidu.adp.lib.c.a.mj().getAddress(false);
            if (!TextUtils.isEmpty(writeData.getTopicId())) {
                this.mNetwork.addPostData("topic_id", writeData.getTopicId());
            }
            this.mNetwork.addPostData("new_vcode", "1");
            String str9 = null;
            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                str2 = str4 + imagesCodeForPost;
                title = writeData.getTitle();
            } else {
                String buildContent = writeData.getVideoInfo().buildContent();
                title = writeData.getTitle();
                str2 = buildContent + imagesCodeForPost;
                str9 = str4 + imagesCodeForPost;
                writeData.setIsNoTitle(at.isEmpty(title));
            }
            String voteContentForPost = writeData.getVoteContentForPost();
            if (!StringUtils.isNull(voteContentForPost)) {
                str2 = str2 + voteContentForPost;
            }
            j.Al(str2);
            String Ia = com.baidu.tieba.face.a.Ia(str2);
            if (!TextUtils.isEmpty(str9)) {
                str9 = com.baidu.tieba.face.a.Ia(str9);
            }
            this.mNetwork.addPostData("content", Ia);
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
            switch (writeData.getType()) {
                case 0:
                case 7:
                case 9:
                    this.mNetwork.setUrl(mpN);
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
                    this.mNetwork.setUrl(mpO);
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
                    if (com.baidu.tbadk.editortools.pb.a.bsY().getStatus() == 1) {
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
                    this.mNetwork.setUrl(mpO);
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
                    this.mNetwork.setUrl(mpN);
                    this.mNetwork.addPostData("fid", writeData.getForumId());
                    this.mNetwork.addPostData("kw", writeData.getForumName());
                    if (!TextUtils.isEmpty(writeData.getTitle())) {
                        this.mNetwork.addPostData("title", writeData.getTitle());
                    }
                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                        this.mNetwork.addPostData("post_prefix", writeData.getPostPrefix());
                    }
                    this.mNetwork.addPostData("thread_type", "33");
                    c.a(this.mNetwork, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 5:
                    this.mNetwork.setUrl(mpO);
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
                    this.mNetwork.setUrl(mpN);
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
        Iu(95);
        if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
            this.mpQ.parserJson(postNetData);
        } else {
            this.mpQ.setError_code(this.mNetwork.isNetSuccess() ? this.mNetwork.getServerErrorCode() : this.mNetwork.getNetErrorCode());
            this.mpQ.setError_msg(this.mNetwork.getErrorString());
        }
        if (this.mpQ.error_code != 0 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mpQ.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
        } else if (this.mpQ.error_code != 0 && writeData.isHasImages() && k.isEmpty(str4 + str3)) {
            this.mpQ.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
        }
        try {
            this.mpR = new AntiData();
            this.mpR.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
        } catch (Exception e2) {
        }
        if (this.mpR.getBlock_stat() == 0 && this.mpQ.error_code == 0 && this.mNetwork.bjL() != null && this.mNetwork.bjL().bkq() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.bjL().bkq().bku()));
        }
        Iu(100);
        return postNetData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu(int i) {
        if (this.mpT != null) {
            this.mpT.Iv(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.bjL().bkr().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.cancelNetConnect();
        }
        if (this.eRB != null) {
            this.eRB.cancel();
        }
        if (this.mpS != null) {
            this.mpS.cancelUpload();
        }
    }

    public AntiData dAS() {
        return this.mpR;
    }

    public ErrorData dAT() {
        return this.mpQ;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }
}
