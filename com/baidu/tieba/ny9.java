package com.baidu.tieba;

import android.location.Address;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.UploadPicParallelSwitch;
import com.baidu.tieba.oy9;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ny9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String i;
    public static final String j;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;
    public ErrorData b;
    public boolean c;
    public String d;
    public AntiData e;
    public ImageUploader f;
    public pz9 g;
    public sx8 h;

    public boolean c(WriteData writeData, boolean z) {
        InterceptResult invokeLZ;
        String returnVoiceMd5;
        boolean z2;
        String str;
        String title;
        String str2;
        WriteData writeData2;
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, writeData, z)) == null) {
            if (writeData == null) {
                o05.b("write", "uploadErrordata");
                return false;
            }
            g0a.a("发帖：postWriteData 开始");
            NetWork netWork = new NetWork();
            this.a = netWork;
            netWork.getNetContext().getRequest().mIsNeedTbs = true;
            this.a.setNeedSig(true);
            this.a.addPostData("authsid", writeData.getAuthSid());
            this.a.addPostData("show_custom_figure", writeData.isShowCustomFigure() ? "1" : "0");
            if (!TextUtils.isEmpty(writeData.getToServerContent())) {
                this.d = writeData.getToServerContent();
            } else {
                this.d = writeData.getContent();
            }
            if (writeData.getPortrait() != null && writeData.getName() != null && writeData.getSubPbReplyPrefix() != null) {
                this.d = "回复 #(reply, " + writeData.getPortrait() + StringUtil.ARRAY_ELEMENT_SEPARATOR + writeData.getName() + ") :" + this.d;
            } else if (writeData.getSubPbReplyPrefix() != null) {
                this.d = writeData.getSubPbReplyPrefix() + this.d;
            }
            g0a.a("发帖：发帖类型：" + writeData.getType());
            g0a.a("发帖：开始分段数据发送");
            if (z && writeData.isHasImages()) {
                WriteImagesInfo writeImagesInfo = writeData.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    writeImagesInfo.needImageParallel = UploadPicParallelSwitch.isOn();
                    writeImagesInfo.imageChunkSize = n95.m().n("key_upload_pic_chunk_size", 0);
                    writeImagesInfo.imageUploadConcurrency = n95.m().n("key_upload_pic_parallel_count", 0);
                    writeImagesInfo.imageChunkRetry = n95.m().n("key_upload_pic_chunk_retry", 0);
                    if (writeImagesInfo.imageUploadConcurrency < 1) {
                        writeImagesInfo.imageUploadConcurrency = 1;
                    }
                }
                e0a.n(writeData);
                g0a.a("发帖：发送图片 开始");
                if (this.f == null) {
                    ImageUploader imageUploader = new ImageUploader("HTTPWriteService.postWriteData");
                    this.f = imageUploader;
                    imageUploader.setWriteData(writeData);
                    this.f.setMultiImageUploadProgressCallback(new a(this, writeImagesInfo, writeData), writeData);
                }
                if (writeData.startPublishTime() > 0 && writeImagesInfo != null) {
                    if (writeImagesInfo.needImageParallel) {
                        this.f.setChunkSize(104857600);
                    } else {
                        int i2 = writeImagesInfo.imageChunkSize;
                        if (i2 > 9) {
                            this.f.setChunkSize(i2 * 1024);
                        } else {
                            this.f.setChunkSize(512000);
                        }
                    }
                }
                g0a.a("发帖：发送图片 上传图片 开始 2");
                this.f.isFromBJH = writeData.isBJHPost();
                ErrorData uploadMustAllSuccInBackground = this.f.uploadMustAllSuccInBackground(writeData.getWriteImagesInfo(), true);
                if (uploadMustAllSuccInBackground != null) {
                    this.b.setError_code(uploadMustAllSuccInBackground.getError_code());
                    this.b.setError_msg(uploadMustAllSuccInBackground.getError_msg());
                    g0a.a("发帖：发送图片 上传图片 错误 2");
                    e0a.e(writeData, uploadMustAllSuccInBackground);
                    o05.b("write", "uploadErrorimg2");
                    return false;
                }
                g0a.a("发帖：发送图片 上传图片 完成 2");
                e0a.e(writeData, null);
            }
            if (this.c) {
                this.b.setError_code(-54);
                o05.b("write", "uploadErrorcancel");
                return false;
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
            g0a.a("声音文件 = " + voice);
            if (voice != null && !z2) {
                g0a.a("发帖：发送声音 开始");
                zb5 zb5Var = new zb5(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                zb5Var.a("type", 1);
                String storeFile = FileHelper.getStoreFile(voice, 1);
                e0a.r(writeData, FileHelper.getFileSize(storeFile));
                yc5 d = zb5Var.d(storeFile);
                if (d != null && d.d()) {
                    xc5 a2 = d.a();
                    if (a2 != null) {
                        returnVoiceMd5 = a2.b();
                        wb5.b(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                        e0a.i(writeData, d);
                        g0a.a("发帖：发送声音 完成 1");
                    } else {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("ErrCode", Integer.valueOf(d.b()));
                        fieldBuilder.append("ErrMsg", d.c());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", fieldBuilder.toString());
                        this.b.setError_code(d.b());
                        this.b.setError_msg(d.c());
                        g0a.a("发帖：发送声音 失败 1");
                        e0a.i(writeData, d);
                        o05.b("write", "uploadErrorvoice1");
                        return false;
                    }
                } else {
                    FieldBuilder fieldBuilder2 = new FieldBuilder();
                    fieldBuilder2.append("audioFile", storeFile);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", fieldBuilder2.toString());
                    if (d != null) {
                        this.b.setError_code(d.b());
                        this.b.setError_msg(d.c());
                    }
                    e0a.i(writeData, d);
                    g0a.a("发帖：发送声音 失败 2");
                    o05.b("write", "uploadErrorvoice2");
                    return false;
                }
            }
            if (this.c) {
                this.b.setError_code(-54);
                o05.b("write", "uploadErrorcancel2");
                return false;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    e0a.p(writeData, videoInfo);
                    this.g = new pz9(this.h);
                    g0a.a("发帖：开始上传视频");
                    VideoFinishResult e = this.g.e(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(this, writeData));
                    e0a.g(writeData, e);
                    if (e == null) {
                        this.b.setError_code(-53);
                        this.b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        g0a.a("发帖：开始上传视频 失败 1");
                        o05.b("write", "uploadErrorvideo1");
                        return false;
                    } else if (e.isSuccess()) {
                        videoInfo.setVideoMd5(e.getVideoMd5());
                        videoInfo.setVideoUrl(e.getVideoUrl());
                        g0a.a("发帖：开始上传视频 成功 ");
                    } else {
                        this.b.setError_code(e.getErrorNo());
                        this.b.setError_msg(e.getUserMessage());
                        g0a.a("发帖：开始上传视频 失败 2");
                        o05.b("write", "uploadErrorvideo2");
                        return false;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    g0a.a("发帖：开始上传首帧图 开始 ");
                    if (this.f == null) {
                        ImageUploader imageUploader2 = new ImageUploader("HTTPWriteService.postWriteData");
                        this.f = imageUploader2;
                        imageUploader2.setWriteData(writeData);
                    }
                    e0a.q(writeData, videoInfo.getThumbPath());
                    ImageUploadResult uploadInBackground = this.f.uploadInBackground(videoInfo.getThumbPath(), false);
                    e0a.h(writeData, uploadInBackground);
                    if (uploadInBackground != null) {
                        videoInfo.setThumbId(uploadInBackground.picId);
                        ImageUploadResult.picInfo picinfo = uploadInBackground.picInfo;
                        if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                            m0a.n(uploadInBackground.picInfo.bigPic.picUrl);
                        }
                    }
                    g0a.a("发帖：开始上传首帧图 完成 ");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!ListUtils.isEmpty(videoInfo.getStickListInfo())) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str3 : videoInfo.getStickListInfo()) {
                            jSONArray.put(str3);
                        }
                        jSONObject.put("sticker_id", jSONArray);
                    }
                    if (!ListUtils.isEmpty(videoInfo.getBeautifyListInfo())) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (String str4 : videoInfo.getBeautifyListInfo()) {
                            jSONArray2.put(str4);
                        }
                        jSONObject.put("beautify_level", jSONArray2);
                    }
                    if (!ListUtils.isEmpty(videoInfo.getFilterListInfo())) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (String str5 : videoInfo.getFilterListInfo()) {
                            jSONArray3.put(str5);
                        }
                        jSONObject.put("filter_id", jSONArray3);
                    }
                    if (!ListUtils.isEmpty(videoInfo.getMusicListInfo())) {
                        JSONArray jSONArray4 = new JSONArray();
                        for (String str6 : videoInfo.getMusicListInfo()) {
                            jSONArray4.put(str6);
                        }
                        jSONObject.put(CloudMusicActivityConfig.MUSIC_ID, jSONArray4);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.a.addPostData("video_other", jSONObject.toString());
            }
            g0a.a("发帖：上传视频结束 完全完成 ");
            if (this.c) {
                this.b.setError_code(-54);
                o05.b("write", "uploadErrorcancel3");
                return false;
            }
            g0a.a("发帖：其他数据设置开始 ");
            this.a.addPostData("anonymous", "1");
            this.a.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
            this.a.addPostData("is_feedback", "0");
            this.a.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
            this.a.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
            if (returnVoiceMd5 != null) {
                this.a.addPostData("voice_md5", returnVoiceMd5);
                this.a.addPostData("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if ((!writeData.isAddThread() || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(this.d) && writeData.getVideoInfo() == null && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                this.b.setError_code(-53);
                this.b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                o05.b("write", "uploadErrorother");
                return false;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.a.addPostData("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.a.addPostData("vcode_md5", writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.a.addPostData("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.a.addPostData("vcode_tag", "12");
            }
            Address j2 = pf.n().j(false);
            if (!TextUtils.isEmpty(writeData.getTopicId())) {
                this.a.addPostData("topic_id", writeData.getTopicId());
            }
            this.a.addPostData("new_vcode", "1");
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload()) {
                String buildContent = writeData.getVideoInfo().buildContent();
                title = writeData.getTitle();
                str = buildContent + imagesCodeForPost;
                StringBuilder sb = new StringBuilder();
                sb.append(StringUtils.isNull(this.d) ? "" : this.d);
                sb.append(imagesCodeForPost);
                String sb2 = sb.toString();
                writeData.setIsNoTitle(ui.isEmpty(title));
                str2 = sb2;
            } else {
                if (writeData.isRichTextEditorMode()) {
                    StringBuilder sb3 = new StringBuilder();
                    for (Object obj : writeData.getServerRichContentData()) {
                        if (obj instanceof String) {
                            sb3.append(obj);
                        } else if (obj instanceof ImageFileInfo) {
                            ImageFileInfo imageFileInfo = (ImageFileInfo) obj;
                            if (imageFileInfo.isAlreadyUploadedToServer()) {
                                sb3.append("\n");
                                sb3.append(imageFileInfo.getServerImageCode());
                            }
                        }
                    }
                    str = sb3.toString();
                    title = writeData.getTitle();
                } else {
                    str = this.d + imagesCodeForPost;
                    title = writeData.getTitle();
                }
                str2 = null;
            }
            if (writeData.isLocalChannelDynamic() && !TextUtils.isEmpty(writeData.getLocalChannelTopic())) {
                title = "#" + writeData.getLocalChannelTopic() + "#" + title;
            }
            String voteContentForPost = writeData.getVoteContentForPost();
            if (!StringUtils.isNull(voteContentForPost)) {
                str = str + voteContentForPost;
            }
            EmotionUtil.statisticsEmotionUse(str);
            String c = k17.c(str);
            if (!TextUtils.isEmpty(str2)) {
                str2 = k17.c(str2);
            }
            String str7 = str2;
            if (writeData.getItemDatas() != null && writeData.getItemDatas().size() > 0) {
                c = c + writeData.getAssociatedItemsForPost();
            }
            this.a.addPostData("content", c);
            this.a.addPostData("reply_uid", writeData.getReplyId());
            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                this.a.addPostData("meme_text", writeData.getMemeText());
            }
            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                this.a.addPostData("meme_cont_sign", writeData.getMemeContSign());
            }
            if (!TextUtils.isEmpty(writeData.getItem_id())) {
                this.a.addPostData("item_id", writeData.getItem_id());
            }
            if (!TextUtils.isEmpty(writeData.getComment_head())) {
                this.a.addPostData("comment_head", writeData.getComment_head());
            }
            if (writeData.getClassAndTagData() != null && !TextUtils.isEmpty(writeData.getClassAndTagData().toPostJson())) {
                this.a.addPostData("works_tag", writeData.getClassAndTagData().toPostJson());
            }
            if (writeData.isFromGameRank()) {
                this.a.addPostData("is_xiuxiu_thread", "1");
            }
            g0a.a("设置数据");
            int type = writeData.getType();
            if (type == 1) {
                writeData2 = writeData;
                this.a.setUrl(j);
                this.a.addPostData("fid", writeData.getForumId());
                this.a.addPostData("from_fourm_id", writeData.getFromForumId());
                this.a.addPostData("v_fid", writeData.getVForumId());
                this.a.addPostData("v_fname", writeData.getVForumName());
                this.a.addPostData("tid", writeData.getThreadId());
                this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                this.a.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                this.a.addPostData("is_barrage", "0");
                this.a.addPostData("barrage_time", "0");
                if (tj5.a().b() == 1) {
                    this.a.addPostData("ptype", "4");
                }
                if (!StringUtils.isNull(writeData2.sourceFrom)) {
                    this.a.addPostData("post_from", writeData2.sourceFrom);
                }
                if (writeData.getBaijiahaoData() != null) {
                    this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                    this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                    this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                    this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                }
                o0a.a(this.a, writeData2);
            } else if (type != 2) {
                if (type != 9) {
                    switch (type) {
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            break;
                        default:
                            if (writeData.isCanNoForum()) {
                                this.a.addPostData("fid", "0");
                                this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                                this.a.addPostData("transform_forums", writeData.getTransmitForumData());
                            } else {
                                this.a.addPostData("fid", writeData.getForumId());
                                this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                            }
                            writeData2 = writeData;
                            break;
                    }
                }
                this.a.setUrl(i);
                o(writeData);
                if (writeData.isCanNoForum()) {
                    this.a.addPostData("fid", "0");
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                    this.a.addPostData("transform_forums", writeData.getTransmitForumData());
                } else {
                    this.a.addPostData("fid", writeData.getForumId());
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                }
                this.a.addPostData("is_hide", writeData.isPrivacy() ? "1" : "0");
                this.a.addPostData("is_repost_to_dynamic", writeData.isToDynamic() ? "1" : "0");
                this.a.addPostData("show_custom_figure", writeData.isShowCustomFigure() ? "1" : "0");
                if (writeData.getVideoId() != null) {
                    this.a.addPostData("video_id", writeData.getVideoId());
                    if (writeData.getOriginalVideoCover() != null) {
                        this.a.addPostData("origin_video_cover", writeData.getOriginalVideoCover());
                    }
                    if (writeData.getOriginalVideoTitle() != null) {
                        this.a.addPostData("origin_video_title", writeData.getOriginalVideoTitle());
                    }
                }
                if (writeData.isShareThread()) {
                    this.a.addPostData("is_share", "1");
                    this.a.addPostData("from_tid", writeData.getOriginalThreadId());
                }
                this.a.addPostData("pro_zone", "0");
                this.a.addPostData(IntentConfig.CALL_FROM, writeData.getStatisticFrom() + "");
                if (!TextUtils.isEmpty(title)) {
                    this.a.addPostData("title", title);
                }
                if (!TextUtils.isEmpty(str7)) {
                    this.a.addPostData(AlbumFloatActivityConfig.VIDEO_ABSTRACT, str7);
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.a.addPostData("post_prefix", writeData.getPostPrefix());
                }
                this.a.addPostData("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                if (writeData.isNoTitle()) {
                    this.a.addPostData("st_type", "notitle");
                }
                if (j2 != null && TbadkCoreApplication.getInst().getIsLocationOn()) {
                    this.a.addPostData("lbs", j2.getLatitude() + "," + j2.getLongitude());
                }
                if (writeData.isLinkThread()) {
                    this.a.addPostData("link_url", writeData.getLinkUrl());
                    this.a.addPostData("link_url_code", writeData.getLinkUrlCode() != null ? writeData.getLinkUrlCode() : "");
                }
                this.a.addPostData("is_link_thread", writeData.isLinkThread() ? "1" : "0");
                if (writeData.isShareThread()) {
                    if (writeData.getOriBaijiahaoData() != null) {
                        this.a.addPostData("ori_ugc_nid", writeData.getOriBaijiahaoData().oriUgcNid);
                        this.a.addPostData("ori_ugc_vid", writeData.getOriBaijiahaoData().oriUgcVid);
                        this.a.addPostData("ori_ugc_tid", writeData.getOriBaijiahaoData().oriUgcTid);
                        this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getOriBaijiahaoData().oriUgcType));
                    }
                } else if (writeData.getBaijiahaoData() != null) {
                    this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                    this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                    this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                }
                if (writeData.getTabId() > 0) {
                    this.a.addPostData("tab_name", writeData.getTabName());
                    this.a.addPostData("tab_id", String.valueOf(writeData.getTabId()));
                    this.a.addPostData("is_general_tab", String.valueOf(writeData.getIsGeneralTab()));
                }
                writeData2 = writeData;
                this.a.addPostData("is_forum_business_account", writeData2.isForumBusinessAccount ? "1" : "0");
                if (writeData.isQuestionThread()) {
                    this.a.addPostData("is_question", "1");
                    this.a.addPostData("question_tag_id", writeData.getQuestionTagId());
                    this.a.addPostData("is_create_tag", writeData.isQuestionTagManualCreated() ? "1" : "0");
                }
            } else {
                writeData2 = writeData;
                this.a.setUrl(j);
                this.a.addPostData("fid", writeData.getForumId());
                this.a.addPostData("from_fourm_id", writeData.getFromForumId());
                this.a.addPostData("v_fid", writeData.getVForumId());
                this.a.addPostData("v_fname", writeData.getVForumName());
                this.a.addPostData("tid", writeData.getThreadId());
                this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                this.a.addPostData("quote_id", String.valueOf(writeData.getFloor()));
                this.a.addPostData("is_twzhibo_thread", String.valueOf(0));
                this.a.addPostData("floor_num", String.valueOf(writeData.getFloorNum()));
                if (writeData.getRepostId() != null) {
                    this.a.addPostData("repostid", writeData.getRepostId());
                }
                if (writeData.getReSubPostId() != null) {
                    this.a.addPostData("sub_post_id", writeData.getReSubPostId());
                }
                this.a.addPostData("is_ad", writeData.getIsAd() ? "1" : "0");
                this.a.addPostData("is_addition", writeData.isAddition() ? "1" : "0");
                this.a.addPostData("is_giftpost", "0");
                if (writeData.isAddition()) {
                    this.a.addPostData("st_type", "conadd");
                }
                if (!StringUtils.isNull(writeData2.sourceFrom)) {
                    this.a.addPostData("post_from", writeData2.sourceFrom);
                }
                if (writeData.getBaijiahaoData() != null) {
                    this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                    this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                    this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                    this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                }
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (writeData.isWork()) {
                this.a.addPostData("is_works", "1");
            }
            this.a.addPostData("is_pictxt", writeData.isRichTextEditorMode() ? "1" : "0");
            this.a.addPostData(WriteActivityConfig.IS_ARTICLE, writeData.getIsArticle());
            this.a.addPostData("is_show_bless", writeData.isShowBless() ? "1" : "0");
            g0a.a("发帖：其他数据设置开始 发送");
            PublishProgressData.valueOf(writeData2, 93).send(true);
            o05.b("write", "upload");
            return true;
        }
        return invokeLZ.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements ImageUploader.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteImagesInfo a;
        public final /* synthetic */ WriteData b;

        public a(ny9 ny9Var, WriteImagesInfo writeImagesInfo, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny9Var, writeImagesInfo, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeImagesInfo;
            this.b = writeData;
        }

        @Override // com.baidu.tbadk.img.ImageUploader.b
        public void a(String str, Object obj, long j, long j2, int i, int i2) {
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                g0a.a("发帖：发送图片 进度 = " + i + "/" + i2 + " :" + j + "/" + j2 + "   ，" + str);
                WriteImagesInfo writeImagesInfo = this.a;
                if (writeImagesInfo != null && (i3 = writeImagesInfo.hasUploadFileSize) > 0 && (i4 = writeImagesInfo.allImageFileSize) > 0) {
                    float f = 1.0f;
                    float f2 = (i3 * 1.0f) / i4;
                    if (f2 <= 1.0f) {
                        f = f2;
                    }
                    PublishProgressData.valueOf(this.b, (int) (f * 90.0f)).send(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements wz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ WriteData b;

        public b(ny9 ny9Var, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny9Var, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeData;
            this.a = 0;
        }

        @Override // com.baidu.tieba.wz9
        public void onProgressUpdate(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                g0a.a("发帖：开始上传视频 percent = " + f);
                int i = (int) (f * 90.0f);
                PublishProgressData.valueOf(this.b, i).send(true);
                if (i != this.a) {
                    this.a = i;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948018939, "Lcom/baidu/tieba/ny9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948018939, "Lcom/baidu/tieba/ny9;");
                return;
            }
        }
        i = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
        j = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
        String str = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    }

    public ny9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.b = new ErrorData();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = true;
            NetWork netWork = this.a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ImageUploader imageUploader = this.f;
            if (imageUploader != null) {
                imageUploader.cancel();
            }
            pz9 pz9Var = this.g;
            if (pz9Var != null) {
                pz9Var.a();
            }
        }
    }

    public AntiData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (AntiData) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            NetWork netWork = this.a;
            if (netWork == null) {
                return 0;
            }
            if (netWork.isNetSuccess()) {
                return this.a.getServerErrorCode();
            }
            return this.a.getNetErrorCode();
        }
        return invokeV.intValue;
    }

    public ErrorData g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (ErrorData) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            NetWork netWork = this.a;
            if (netWork == null) {
                return "";
            }
            return netWork.getErrorString();
        }
        return (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            NetWork netWork = this.a;
            if (netWork == null) {
                return false;
            }
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return invokeV.booleanValue;
    }

    public String a(oy9 oy9Var, WriteData writeData, boolean z, oy9.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{oy9Var, writeData, Boolean.valueOf(z), eVar})) == null) {
            o05.b("write", "postP");
            boolean c = c(writeData, z);
            if (oy9Var != null && this.a != null) {
                if (!c) {
                    eVar.a(new k0a());
                    return null;
                }
                o05.b("write", "postR");
                oy9Var.e(eVar);
                oy9Var.b(this.a);
                return null;
            }
            eVar.a(new k0a());
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public String b(oy9 oy9Var, WriteData writeData, boolean z, oy9.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{oy9Var, writeData, Boolean.valueOf(z), eVar})) == null) {
            o05.b("write", "threadP");
            boolean c = c(writeData, z);
            if (oy9Var != null && this.a != null) {
                if (!c) {
                    eVar.a(new k0a());
                    return null;
                }
                o05.b("write", "threadR");
                oy9Var.e(eVar);
                oy9Var.c(this.a);
                return null;
            }
            eVar.a(new k0a());
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public String j(WriteData writeData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, writeData, z)) == null) {
            o05.b("write", "json");
            boolean c = c(writeData, z);
            if (this.a == null || !c) {
                return null;
            }
            o05.b("write", "jsonR");
            return this.a.postNetData();
        }
        return (String) invokeLZ.objValue;
    }

    public void k(WriteData writeData, n0a n0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, writeData, n0aVar) == null) && writeData != null && n0aVar != null) {
            g0a.a("发帖：其他数据设置开始 结束 进度到 95");
            PublishProgressData.valueOf(writeData, 95).send(true);
            if (this.b.getError_code() == -1 && this.b.getError_msg() == null) {
                this.b.setError_code(n0aVar.a());
                this.b.setError_msg(n0aVar.c());
                this.b.setError_data(n0aVar.b());
            }
            if (this.b.error_code != 0 && !BdNetTypeUtil.isNetWorkAvailable()) {
                this.b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0def));
            } else if (this.b.error_code != 0 && writeData.isHasImages()) {
                if (ui.isEmpty(this.d + writeData.getImagesCodeForPost())) {
                    this.b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
                }
            }
            try {
                AntiData antiData = new AntiData();
                this.e = antiData;
                antiData.parserJson(n0aVar.d().optJSONObject("anti_stat"));
            } catch (Exception unused) {
            }
            if (this.e.getBlock_stat() == 0 && this.b.error_code == 0 && this.a.getNetContext() != null && this.a.getNetContext().getRequest() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.a.getNetContext().getRequest()));
            }
            g0a.a("发帖：处理整个 发帖过程 结束数据 完成 进度到 100");
        }
    }

    public void l(sx8 sx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sx8Var) == null) {
            this.h = sx8Var;
        }
    }

    public boolean m(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, writeData)) == null) {
            if (writeData == null) {
                return false;
            }
            int type = writeData.getType();
            if (type != 1 && type != 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean n(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, writeData)) == null) {
            if (writeData == null) {
                return false;
            }
            return writeData.isAddThread();
        }
        return invokeL.booleanValue;
    }

    public void o(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, writeData) != null) || writeData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_POST_THREAD_AT_USE_CONDITION);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (ui.isEmpty(writeData.getAtUidListString())) {
            statisticItem.param("obj_param1", "0");
        } else {
            statisticItem.param("obj_param1", "1");
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
        }
        TiebaStatic.log(statisticItem);
    }
}
