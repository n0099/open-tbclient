package com.baidu.tieba.write.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.yh5;
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
    public Map requestData;

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
            yh5.c(builder, true, true, true);
            builder.authsid = (String) this.requestData.get("authsid");
            builder.sig = (String) this.requestData.get(FunAdSdk.PLATFORM_SIG);
            builder.tbs = (String) this.requestData.get(HttpRequest.TBS);
            builder.video_other = (String) this.requestData.get("video_other");
            builder.anonymous = (String) this.requestData.get("anonymous");
            builder.can_no_forum = (String) this.requestData.get("can_no_forum");
            builder.is_feedback = (String) this.requestData.get("is_feedback");
            builder.takephoto_num = (String) this.requestData.get("takephoto_num");
            builder.entrance_type = (String) this.requestData.get("entrance_type");
            builder.voice_md5 = (String) this.requestData.get("voice_md5");
            builder.during_time = (String) this.requestData.get("during_time");
            builder.vcode = (String) this.requestData.get("vcode");
            builder.vcode_md5 = (String) this.requestData.get("vcode_md5");
            builder.vcode_type = (String) this.requestData.get("vcode_type");
            builder.vcode_tag = (String) this.requestData.get("vcode_tag");
            builder.topic_id = (String) this.requestData.get("topic_id");
            builder.new_vcode = (String) this.requestData.get("new_vcode");
            builder.content = (String) this.requestData.get("content");
            builder.reply_uid = (String) this.requestData.get("reply_uid");
            builder.meme_text = (String) this.requestData.get("meme_text");
            builder.meme_cont_sign = (String) this.requestData.get("meme_cont_sign");
            builder.item_id = (String) this.requestData.get("item_id");
            builder.comment_head = (String) this.requestData.get("comment_head");
            builder.works_tag = (String) this.requestData.get("works_tag");
            builder.fid = (String) this.requestData.get("fid");
            builder.kw = (String) this.requestData.get(TiebaStatic.Params.H5_FORUM_NAME);
            builder.transform_forums = (String) this.requestData.get("transform_forums");
            builder.is_hide = (String) this.requestData.get("is_hide");
            builder.is_repost_to_dynamic = (String) this.requestData.get("is_repost_to_dynamic");
            builder.video_id = (String) this.requestData.get("video_id");
            builder.origin_video_cover = (String) this.requestData.get("origin_video_cover");
            builder.origin_video_title = (String) this.requestData.get("origin_video_title");
            builder.is_share = (String) this.requestData.get("is_share");
            builder.from_tid = (String) this.requestData.get("from_tid");
            builder.pro_zone = (String) this.requestData.get(EditVideoActivityConfig.KEY_PRO_ZONE);
            builder.call_from = (String) this.requestData.get(IntentConfig.CALL_FROM);
            builder.title = (String) this.requestData.get("title");
            builder.video_abstract = (String) this.requestData.get(AlbumFloatActivityConfig.VIDEO_ABSTRACT);
            builder.post_prefix = (String) this.requestData.get("post_prefix");
            builder.is_ntitle = (String) this.requestData.get("is_ntitle");
            builder.st_type = (String) this.requestData.get("st_type");
            builder.lbs = (String) this.requestData.get("lbs");
            builder.is_location = (String) this.requestData.get("is_location");
            builder.lat = (String) this.requestData.get(SuggestAddrField.KEY_LAT);
            builder.lng = (String) this.requestData.get(SuggestAddrField.KEY_LNG);
            builder.name = (String) this.requestData.get("name");
            builder.sn = (String) this.requestData.get("sn");
            builder.is_bottle = (String) this.requestData.get("is_bottle");
            builder.recommend_ext = (String) this.requestData.get("recommend_ext");
            builder.link_url = (String) this.requestData.get("link_url");
            builder.link_url_code = (String) this.requestData.get("link_url_code");
            builder.is_link_thread = (String) this.requestData.get("is_link_thread");
            builder.ori_ugc_nid = (String) this.requestData.get("ori_ugc_nid");
            builder.ori_ugc_vid = (String) this.requestData.get("ori_ugc_vid");
            builder.ori_ugc_tid = (String) this.requestData.get("ori_ugc_tid");
            builder.ori_ugc_type = (String) this.requestData.get(TiebaStatic.Params.UGC_TYPE);
            builder.tab_name = (String) this.requestData.get("tab_name");
            builder.tab_id = (String) this.requestData.get(TiebaStatic.Params.TAB_ID);
            builder.is_general_tab = (String) this.requestData.get("is_general_tab");
            builder.is_forum_business_account = (String) this.requestData.get("is_forum_business_account");
            builder.thread_type = (String) this.requestData.get("thread_type");
            builder.tbopen_app_key = (String) this.requestData.get("tbopen_app_key");
            builder.tbopen_app_icon = (String) this.requestData.get("tbopen_app_icon");
            builder.tbopen_app_name = (String) this.requestData.get("tbopen_app_name");
            builder.share_abstract = (String) this.requestData.get("share_abstract");
            builder.share_image = (String) this.requestData.get("share_image");
            builder.share_h5_url = (String) this.requestData.get("share_h5_url");
            builder.share_swan_app_key = (String) this.requestData.get("share_swan_app_key");
            builder.share_swan_path = (String) this.requestData.get("share_swan_path");
            builder.real_lat = (String) this.requestData.get("real_lat");
            builder.real_lng = (String) this.requestData.get("real_lng");
            builder.name_show = (String) this.requestData.get("name_show");
            builder.is_works = (String) this.requestData.get("is_works");
            builder.is_pictxt = (String) this.requestData.get("is_pictxt");
            builder.first_frame_pid = (String) this.requestData.get("first_frame_pid");
            builder.is_article = (String) this.requestData.get(WriteActivityConfig.IS_ARTICLE);
            builder.from_category_id = (String) this.requestData.get("fromCategoryId");
            builder.to_category_id = (String) this.requestData.get("toCategoryId");
            if (!TextUtils.isEmpty((CharSequence) this.requestData.get("is_question"))) {
                try {
                    builder.is_question = Integer.valueOf(Integer.parseInt((String) this.requestData.get("is_question")));
                    builder.question_tag_id = (String) this.requestData.get("question_tag_id");
                    builder.is_create_tag = Integer.valueOf(Integer.parseInt((String) this.requestData.get("is_create_tag")));
                } catch (NumberFormatException unused) {
                }
            }
            try {
                builder.show_custom_figure = Integer.valueOf(Integer.parseInt((String) this.requestData.get("show_custom_figure")));
            } catch (NumberFormatException unused2) {
            }
            AddThreadReqIdl.Builder builder2 = new AddThreadReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setRequestData(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
            this.requestData = map;
        }
    }
}
