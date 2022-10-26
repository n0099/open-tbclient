package com.baidu.tieba.write.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import tbclient.AddPost.AddPostReqIdl;
import tbclient.AddPost.DataReq;
/* loaded from: classes6.dex */
public class AddPostRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map requestData;

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
            builder.transform_forums = (String) this.requestData.get("transform_forums");
            builder.v_fid = (String) this.requestData.get("v_fid");
            builder.v_fname = (String) this.requestData.get("v_fname");
            builder.kw = (String) this.requestData.get(TiebaStatic.Params.H5_FORUM_NAME);
            builder.is_barrage = (String) this.requestData.get("is_barrage");
            builder.barrage_time = (String) this.requestData.get("barrage_time");
            builder.st_param = (String) this.requestData.get("st_param");
            builder.ptype = (String) this.requestData.get("ptype");
            builder.ori_ugc_nid = (String) this.requestData.get("ori_ugc_nid");
            builder.ori_ugc_vid = (String) this.requestData.get("ori_ugc_vid");
            builder.ori_ugc_tid = (String) this.requestData.get("ori_ugc_tid");
            builder.ori_ugc_type = (String) this.requestData.get(TiebaStatic.Params.UGC_TYPE);
            builder.is_location = (String) this.requestData.get("is_location");
            builder.lat = (String) this.requestData.get(SuggestAddrField.KEY_LAT);
            builder.lng = (String) this.requestData.get(SuggestAddrField.KEY_LNG);
            builder.name = (String) this.requestData.get("name");
            builder.sn = (String) this.requestData.get("sn");
            builder.from_fourm_id = (String) this.requestData.get("from_fourm_id");
            builder.tid = (String) this.requestData.get("tid");
            builder.quote_id = (String) this.requestData.get("quote_id");
            builder.is_twzhibo_thread = (String) this.requestData.get("is_twzhibo_thread");
            builder.floor_num = (String) this.requestData.get("floor_num");
            builder.repostid = (String) this.requestData.get("repostid");
            builder.sub_post_id = (String) this.requestData.get("sub_post_id");
            builder.is_ad = (String) this.requestData.get("is_ad");
            builder.is_addition = (String) this.requestData.get("is_addition");
            builder.is_giftpost = (String) this.requestData.get("is_giftpost");
            builder.st_type = (String) this.requestData.get("st_type");
            builder.post_from = (String) this.requestData.get("post_from");
            builder.real_lat = (String) this.requestData.get("real_lat");
            builder.real_lng = (String) this.requestData.get("real_lng");
            builder.name_show = (String) this.requestData.get("name_show");
            builder.is_works = (String) this.requestData.get("is_works");
            builder.is_pictxt = (String) this.requestData.get("is_pictxt");
            builder.is_story = (String) this.requestData.get("is_story");
            builder.jid = (String) this.requestData.get("jid");
            builder.jfrom = (String) this.requestData.get("jfrom");
            builder.from_category_id = (String) this.requestData.get("fromCategoryId");
            builder.to_category_id = (String) this.requestData.get("toCategoryId");
            try {
                builder.show_custom_figure = Integer.valueOf(Integer.parseInt((String) this.requestData.get("show_custom_figure")));
            } catch (NumberFormatException unused) {
            }
            AddPostReqIdl.Builder builder2 = new AddPostReqIdl.Builder();
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
