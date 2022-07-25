package com.baidu.tieba.write.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.repackage.ud5;
import java.util.Map;
import tbclient.AddPost.AddPostReqIdl;
import tbclient.AddPost.DataReq;
/* loaded from: classes4.dex */
public class AddPostRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> requestData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPostRequest() {
        super(CmdConfigHttp.CMD_WRITE_POST_ADD, 309731);
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
            ud5.c(builder, true, true, true);
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
            builder.transform_forums = this.requestData.get("transform_forums");
            builder.v_fid = this.requestData.get("v_fid");
            builder.v_fname = this.requestData.get("v_fname");
            builder.kw = this.requestData.get(TiebaStatic.Params.H5_FORUM_NAME);
            builder.is_barrage = this.requestData.get("is_barrage");
            builder.barrage_time = this.requestData.get("barrage_time");
            builder.st_param = this.requestData.get("st_param");
            builder.ptype = this.requestData.get("ptype");
            builder.ori_ugc_nid = this.requestData.get("ori_ugc_nid");
            builder.ori_ugc_vid = this.requestData.get("ori_ugc_vid");
            builder.ori_ugc_tid = this.requestData.get("ori_ugc_tid");
            builder.ori_ugc_type = this.requestData.get(TiebaStatic.Params.UGC_TYPE);
            builder.is_location = this.requestData.get("is_location");
            builder.lat = this.requestData.get(SuggestAddrField.KEY_LAT);
            builder.lng = this.requestData.get(SuggestAddrField.KEY_LNG);
            builder.name = this.requestData.get("name");
            builder.sn = this.requestData.get("sn");
            builder.from_fourm_id = this.requestData.get("from_fourm_id");
            builder.tid = this.requestData.get("tid");
            builder.quote_id = this.requestData.get("quote_id");
            builder.is_twzhibo_thread = this.requestData.get("is_twzhibo_thread");
            builder.floor_num = this.requestData.get("floor_num");
            builder.repostid = this.requestData.get("repostid");
            builder.sub_post_id = this.requestData.get("sub_post_id");
            builder.is_ad = this.requestData.get("is_ad");
            builder.is_addition = this.requestData.get("is_addition");
            builder.is_giftpost = this.requestData.get("is_giftpost");
            builder.st_type = this.requestData.get("st_type");
            builder.post_from = this.requestData.get("post_from");
            builder.real_lat = this.requestData.get("real_lat");
            builder.real_lng = this.requestData.get("real_lng");
            builder.name_show = this.requestData.get("name_show");
            builder.is_works = this.requestData.get("is_works");
            builder.is_pictxt = this.requestData.get("is_pictxt");
            builder.is_story = this.requestData.get("is_story");
            builder.jid = this.requestData.get("jid");
            builder.jfrom = this.requestData.get("jfrom");
            builder.from_category_id = this.requestData.get("fromCategoryId");
            builder.to_category_id = this.requestData.get("toCategoryId");
            try {
                builder.show_custom_figure = Integer.valueOf(Integer.parseInt(this.requestData.get("show_custom_figure")));
            } catch (NumberFormatException unused) {
            }
            AddPostReqIdl.Builder builder2 = new AddPostReqIdl.Builder();
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
