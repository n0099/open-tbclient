package com.baidu.tieba.write.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.gg;
import com.baidu.tieba.jr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.Map;
import tbclient.AddThread.AddThreadReqIdl;
import tbclient.AddThread.DataReq;
/* loaded from: classes6.dex */
public class AddThreadRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> requestData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddThreadRequest() {
        super(CmdConfigHttp.CMD_WRITE_THREAD_ADD, 309730);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            jr5.c(builder, true, true, true);
            builder.authsid = this.requestData.get("authsid");
            builder.sig = this.requestData.get(FunAdSdk.PLATFORM_SIG);
            builder.tbs = this.requestData.get(HttpRequest.TBS);
            builder.video_other = this.requestData.get("video_other");
            builder.anonymous = this.requestData.get("anonymous");
            builder.can_no_forum = this.requestData.get("can_no_forum");
            builder.is_feedback = this.requestData.get("is_feedback");
            builder.takephoto_num = this.requestData.get("takephoto_num");
            builder.entrance_type = this.requestData.get("entrance_type");
            builder.voice_md5 = this.requestData.get("voice_md5");
            builder.during_time = this.requestData.get("during_time");
            builder.vcode = this.requestData.get("vcode");
            builder.vcode_md5 = this.requestData.get("vcode_md5");
            builder.vcode_type = this.requestData.get("vcode_type");
            builder.vcode_tag = this.requestData.get("vcode_tag");
            builder.topic_id = this.requestData.get("topic_id");
            builder.new_vcode = this.requestData.get("new_vcode");
            builder.content = this.requestData.get("content");
            builder.reply_uid = this.requestData.get("reply_uid");
            builder.meme_text = this.requestData.get("meme_text");
            builder.meme_cont_sign = this.requestData.get("meme_cont_sign");
            builder.item_id = this.requestData.get("item_id");
            builder.comment_head = this.requestData.get("comment_head");
            builder.works_tag = this.requestData.get("works_tag");
            builder.fid = this.requestData.get("fid");
            builder.kw = this.requestData.get(TiebaStatic.Params.H5_FORUM_NAME);
            builder.transform_forums = this.requestData.get("transform_forums");
            builder.is_hide = this.requestData.get("is_hide");
            builder.is_repost_to_dynamic = this.requestData.get("is_repost_to_dynamic");
            builder.video_id = this.requestData.get("video_id");
            builder.origin_video_cover = this.requestData.get("origin_video_cover");
            builder.origin_video_title = this.requestData.get("origin_video_title");
            builder.is_share = this.requestData.get("is_share");
            builder.from_tid = this.requestData.get("from_tid");
            builder.pro_zone = this.requestData.get("pro_zone");
            builder.call_from = this.requestData.get(IntentConfig.CALL_FROM);
            builder.title = this.requestData.get("title");
            builder.video_abstract = this.requestData.get(AlbumFloatActivityConfig.VIDEO_ABSTRACT);
            builder.post_prefix = this.requestData.get("post_prefix");
            builder.is_ntitle = this.requestData.get("is_ntitle");
            builder.st_type = this.requestData.get("st_type");
            builder.lbs = this.requestData.get("lbs");
            builder.is_location = this.requestData.get("is_location");
            builder.lat = this.requestData.get(SuggestAddrField.KEY_LAT);
            builder.lng = this.requestData.get(SuggestAddrField.KEY_LNG);
            builder.name = this.requestData.get("name");
            builder.sn = this.requestData.get("sn");
            builder.is_bottle = this.requestData.get("is_bottle");
            builder.recommend_ext = this.requestData.get("recommend_ext");
            builder.link_url = this.requestData.get("link_url");
            builder.link_url_code = this.requestData.get("link_url_code");
            builder.is_link_thread = this.requestData.get("is_link_thread");
            builder.ori_ugc_nid = this.requestData.get("ori_ugc_nid");
            builder.ori_ugc_vid = this.requestData.get("ori_ugc_vid");
            builder.ori_ugc_tid = this.requestData.get("ori_ugc_tid");
            builder.ori_ugc_type = this.requestData.get(TiebaStatic.Params.UGC_TYPE);
            builder.tab_name = this.requestData.get("tab_name");
            builder.tab_id = this.requestData.get(TiebaStatic.Params.TAB_ID);
            builder.is_general_tab = this.requestData.get("is_general_tab");
            builder.is_forum_business_account = this.requestData.get("is_forum_business_account");
            builder.thread_type = this.requestData.get("thread_type");
            builder.tbopen_app_key = this.requestData.get("tbopen_app_key");
            builder.tbopen_app_icon = this.requestData.get("tbopen_app_icon");
            builder.tbopen_app_name = this.requestData.get("tbopen_app_name");
            builder.share_abstract = this.requestData.get("share_abstract");
            builder.share_image = this.requestData.get("share_image");
            builder.share_h5_url = this.requestData.get("share_h5_url");
            builder.share_naws_app_key = this.requestData.get("share_naws_app_key");
            builder.share_naws_path = this.requestData.get("share_naws_path");
            builder.real_lat = this.requestData.get("real_lat");
            builder.real_lng = this.requestData.get("real_lng");
            builder.name_show = this.requestData.get("name_show");
            builder.is_works = this.requestData.get("is_works");
            builder.is_pictxt = this.requestData.get("is_pictxt");
            builder.first_frame_pid = this.requestData.get("first_frame_pid");
            builder.is_article = this.requestData.get(WriteActivityConfig.IS_ARTICLE);
            builder.from_category_id = this.requestData.get("fromCategoryId");
            builder.to_category_id = this.requestData.get("toCategoryId");
            builder.is_xiuxiu_thread = Integer.valueOf(gg.e(this.requestData.get("is_xiuxiu_thread"), 0));
            builder.is_show_bless = Integer.valueOf(gg.e(this.requestData.get("is_show_bless"), 0));
            if (!TextUtils.isEmpty(this.requestData.get("is_question"))) {
                try {
                    builder.is_question = Integer.valueOf(Integer.parseInt(this.requestData.get("is_question")));
                    builder.question_tag_id = this.requestData.get("question_tag_id");
                    builder.is_create_tag = Integer.valueOf(Integer.parseInt(this.requestData.get("is_create_tag")));
                } catch (NumberFormatException unused) {
                }
            }
            try {
                builder.show_custom_figure = Integer.valueOf(Integer.parseInt(this.requestData.get("show_custom_figure")));
            } catch (NumberFormatException unused2) {
            }
            AddThreadReqIdl.Builder builder2 = new AddThreadReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setRequestData(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
            this.requestData = map;
        }
    }
}
