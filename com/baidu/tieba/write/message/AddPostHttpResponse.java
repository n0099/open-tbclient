package com.baidu.tieba.write.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AddPost.AddPostResIdl;
import tbclient.AddPost.DataRes;
import tbclient.ToastConfig;
/* loaded from: classes4.dex */
public class AddPostHttpResponse extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String resultData;
    public JSONObject resultJSON;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPostHttpResponse(int i) {
        super(CmdConfigHttp.CMD_WRITE_POST_ADD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public JSONObject getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resultJSON : (JSONObject) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            AddPostHttpResponse addPostHttpResponse = this;
            AddPostResIdl addPostResIdl = (AddPostResIdl) new Wire(new Class[0]).parseFrom(bArr, AddPostResIdl.class);
            if (addPostResIdl == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            addPostHttpResponse.resultJSON = jSONObject;
            DataRes dataRes = addPostResIdl.data;
            if (dataRes != null) {
                jSONObject.put("opgroup", dataRes.opgroup);
                addPostHttpResponse.resultJSON.put("tid", addPostResIdl.data.tid);
                addPostHttpResponse.resultJSON.put("pid", addPostResIdl.data.pid);
                addPostHttpResponse.resultJSON.put("video_id", addPostResIdl.data.video_id);
                addPostHttpResponse.resultJSON.put("msg", addPostResIdl.data.msg);
                addPostHttpResponse.resultJSON.put("pre_msg", addPostResIdl.data.pre_msg);
                addPostHttpResponse.resultJSON.put("color_msg", addPostResIdl.data.color_msg);
                if (addPostResIdl.data.twzhibo_info != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("is_copytwzhibo", addPostResIdl.data.twzhibo_info.is_copytwzhibo);
                    addPostHttpResponse.resultJSON.put("twzhibo_info", jSONObject2);
                }
                if (addPostResIdl.data.exp != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("pre_msg", addPostResIdl.data.exp.pre_msg);
                    jSONObject3.put("color_msg", addPostResIdl.data.exp.color_msg);
                    jSONObject3.put("current_level_max_exp", addPostResIdl.data.exp.current_level_max_exp);
                    jSONObject3.put("current_level", addPostResIdl.data.exp.current_level);
                    jSONObject3.put("old", addPostResIdl.data.exp.old);
                    jSONObject3.put("inc", addPostResIdl.data.exp.inc);
                    jSONObject3.put("question_exp", addPostResIdl.data.exp.question_exp);
                    jSONObject3.put("question_msg", addPostResIdl.data.exp.question_msg);
                    addPostHttpResponse.resultJSON.put("exp", jSONObject3);
                }
                if (addPostResIdl.data.contri_info != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("color_msg", addPostResIdl.data.contri_info.color_msg);
                    jSONObject4.put("after_msg", addPostResIdl.data.contri_info.after_msg);
                    List<ToastConfig> list = addPostResIdl.data.contri_info.toast_config;
                    if (list != null) {
                        JSONArray jSONArray = new JSONArray();
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            ToastConfig toastConfig = list.get(i2);
                            if (toastConfig != null) {
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("pre_color_msg", toastConfig.pre_color_msg);
                                jSONObject5.put("toast_back_image", toastConfig.toast_back_image);
                                jSONArray.put(jSONObject5);
                            }
                        }
                        jSONObject4.put("toast_config", jSONArray);
                    }
                    addPostHttpResponse.resultJSON.put("contri_info", jSONObject4);
                }
                if (addPostResIdl.data.star_info != null) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("activity_id", addPostResIdl.data.star_info.activity_id);
                    jSONObject6.put("video_url", addPostResIdl.data.star_info.video_url);
                    jSONObject6.put("pop_text", addPostResIdl.data.star_info.pop_text);
                    jSONObject6.put("pop_imageurl", addPostResIdl.data.star_info.pop_imageurl);
                    if (addPostResIdl.data.star_info.share_info != null) {
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("title", addPostResIdl.data.star_info.share_info.title);
                        jSONObject7.put("content", addPostResIdl.data.star_info.share_info.content);
                        jSONObject7.put("url", addPostResIdl.data.star_info.share_info.url);
                        jSONObject7.put("imageurl", addPostResIdl.data.star_info.share_info.imageurl);
                        jSONObject6.put("share_info", jSONObject7);
                    }
                    addPostHttpResponse.resultJSON.put("star_info", jSONObject6);
                }
                if (addPostResIdl.data.advertisement != null) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("pic", addPostResIdl.data.advertisement.pic);
                    jSONObject8.put("pic_click", addPostResIdl.data.advertisement.pic_click);
                    jSONObject8.put("jump_link", addPostResIdl.data.advertisement.jump_link);
                    jSONObject8.put("advertisement_id", addPostResIdl.data.advertisement.advertisement_id);
                    jSONObject8.put("view_statistics_url", addPostResIdl.data.advertisement.view_statistics_url);
                    jSONObject8.put("click_statistics_url", addPostResIdl.data.advertisement.click_statistics_url);
                    jSONObject8.put("floating_text", addPostResIdl.data.advertisement.floating_text);
                    jSONObject8.put("scheme", addPostResIdl.data.advertisement.scheme);
                    jSONObject8.put("package_name", addPostResIdl.data.advertisement.package_name);
                    jSONObject8.put("display_ad_icon", addPostResIdl.data.advertisement.display_ad_icon);
                    addPostHttpResponse.resultJSON.put("advertisement", jSONObject8);
                }
                if (addPostResIdl.data.icon_stamp_info != null) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("stamp_title", addPostResIdl.data.icon_stamp_info.stamp_title);
                    jSONObject9.put("stamp_text", addPostResIdl.data.icon_stamp_info.stamp_text);
                    jSONObject9.put("stamp_type", addPostResIdl.data.icon_stamp_info.stamp_type);
                    addPostHttpResponse.resultJSON.put("icon_stamp_info", jSONObject9);
                }
                if (addPostResIdl.data.info != null) {
                    JSONObject jSONObject10 = new JSONObject();
                    if (addPostResIdl.data.info.access_state != null) {
                        JSONObject jSONObject11 = new JSONObject();
                        str = "content";
                        jSONObject11.put("type", addPostResIdl.data.info.access_state.type);
                        jSONObject11.put("token", addPostResIdl.data.info.access_state.token);
                        if (addPostResIdl.data.info.access_state.userinfo != null) {
                            JSONObject jSONObject12 = new JSONObject();
                            jSONObject12.put("bduss", addPostResIdl.data.info.access_state.userinfo.bduss);
                            jSONObject12.put("strMobile", addPostResIdl.data.info.access_state.userinfo.mobile);
                            jSONObject12.put("strEmail", addPostResIdl.data.info.access_state.userinfo.email);
                            jSONObject11.put(TableDefine.DB_TABLE_USERINFO, jSONObject12);
                        }
                        jSONObject10.put(AccountAccessActivityConfig.KEY_ACCESS_STATE, jSONObject11);
                    } else {
                        str = "content";
                    }
                    if (addPostResIdl.data.info.confilter_hitwords != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i3 = 0; i3 < addPostResIdl.data.info.confilter_hitwords.size(); i3++) {
                            jSONArray2.put(addPostResIdl.data.info.confilter_hitwords.get(i3));
                        }
                        jSONObject10.put("confilter_hitwords", jSONArray2);
                    }
                    jSONObject10.put("need_vcode", addPostResIdl.data.info.need_vcode);
                    jSONObject10.put("vcode_md5", addPostResIdl.data.info.vcode_md5);
                    jSONObject10.put("vcode_prev_type", addPostResIdl.data.info.vcode_prev_type);
                    jSONObject10.put("vcode_type", addPostResIdl.data.info.vcode_type);
                    jSONObject10.put("pass_token", addPostResIdl.data.info.pass_token);
                    jSONObject10.put("block_content", addPostResIdl.data.info.block_content);
                    jSONObject10.put("block_cancel", addPostResIdl.data.info.block_cancel);
                    jSONObject10.put("block_confirm", addPostResIdl.data.info.block_confirm);
                    jSONObject10.put("vcode_pic_url", addPostResIdl.data.info.vcode_pic_url);
                    if (addPostResIdl.data.info.vcode_extra != null) {
                        JSONObject jSONObject13 = new JSONObject();
                        jSONObject13.put("textimg", addPostResIdl.data.info.vcode_extra.textimg);
                        jSONObject13.put("slideimg", addPostResIdl.data.info.vcode_extra.slideimg);
                        jSONObject13.put(ContentUtil.RESULT_KEY_ENDPOINT, addPostResIdl.data.info.vcode_extra.endpoint);
                        jSONObject13.put("successimg", addPostResIdl.data.info.vcode_extra.successimg);
                        jSONObject13.put("slideendpoint", addPostResIdl.data.info.vcode_extra.slideendpoint);
                        jSONObject10.put("vcode_extra", jSONObject13);
                    }
                    addPostHttpResponse = this;
                    addPostHttpResponse.resultJSON.put("info", jSONObject10);
                } else {
                    str = "content";
                }
                if (addPostResIdl.data.anti_stat != null) {
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("ifpost", addPostResIdl.data.anti_stat.ifpost);
                    jSONObject14.put("ifposta", addPostResIdl.data.anti_stat.ifposta);
                    jSONObject14.put("forbid_flag", addPostResIdl.data.anti_stat.forbid_flag);
                    jSONObject14.put(HttpRequest.TBS, addPostResIdl.data.anti_stat.tbs);
                    jSONObject14.put("need_vcode", addPostResIdl.data.anti_stat.need_vcode);
                    jSONObject14.put("vcode_md5", addPostResIdl.data.anti_stat.vcode_md5);
                    jSONObject14.put("vcode_pic_url", addPostResIdl.data.anti_stat.vcode_pic_url);
                    jSONObject14.put("forbid_info", addPostResIdl.data.anti_stat.forbid_info);
                    jSONObject14.put("ifvoice", addPostResIdl.data.anti_stat.ifvoice);
                    jSONObject14.put("voice_message", addPostResIdl.data.anti_stat.voice_message);
                    jSONObject14.put("block_stat", addPostResIdl.data.anti_stat.block_stat);
                    jSONObject14.put("hide_stat", addPostResIdl.data.anti_stat.hide_stat);
                    jSONObject14.put("vcode_stat", addPostResIdl.data.anti_stat.vcode_stat);
                    jSONObject14.put("days_tofree", addPostResIdl.data.anti_stat.days_tofree);
                    jSONObject14.put("has_chance", addPostResIdl.data.anti_stat.has_chance);
                    jSONObject14.put("ifaddition", addPostResIdl.data.anti_stat.ifaddition);
                    jSONObject14.put("poll_message", addPostResIdl.data.anti_stat.poll_message);
                    jSONObject14.put("video_message", addPostResIdl.data.anti_stat.video_message);
                    if (addPostResIdl.data.anti_stat.block_pop_info != null) {
                        JSONObject jSONObject15 = new JSONObject();
                        jSONObject15.put("ahead_info", addPostResIdl.data.anti_stat.block_pop_info.ahead_info);
                        jSONObject15.put("ahead_url", addPostResIdl.data.anti_stat.block_pop_info.ahead_url);
                        jSONObject15.put("ok_info", addPostResIdl.data.anti_stat.block_pop_info.ok_info);
                        jSONObject15.put("can_post", addPostResIdl.data.anti_stat.block_pop_info.can_post);
                        jSONObject15.put("block_info", addPostResIdl.data.anti_stat.block_pop_info.block_info);
                        jSONObject15.put("sub_block_info", addPostResIdl.data.anti_stat.block_pop_info.sub_block_info);
                        jSONObject15.put("ahead_type", addPostResIdl.data.anti_stat.block_pop_info.ahead_type);
                        jSONObject14.put("block_pop_info", jSONObject15);
                    }
                    jSONObject14.put("reply_private_flag", addPostResIdl.data.anti_stat.reply_private_flag);
                    jSONObject14.put("poll_level", addPostResIdl.data.anti_stat.poll_level);
                    jSONObject14.put("is_sexyforum", addPostResIdl.data.anti_stat.is_sexyforum);
                    jSONObject14.put("teenmode_interval", addPostResIdl.data.anti_stat.teenmode_interval);
                    addPostHttpResponse.resultJSON.put("anti_stat", jSONObject14);
                }
                if (addPostResIdl.data.tb_hudong != null) {
                    JSONObject jSONObject16 = new JSONObject();
                    jSONObject16.put(str, addPostResIdl.data.tb_hudong.content);
                    addPostHttpResponse.resultJSON.put("tb_hudong", jSONObject16);
                }
                if (addPostResIdl.data.anti != null) {
                    JSONObject jSONObject17 = new JSONObject();
                    jSONObject17.put("vcode_md5", addPostResIdl.data.anti.vcode_md5);
                    jSONObject17.put("vcode_pic_url", addPostResIdl.data.anti.vcode_pic_url);
                    jSONObject17.put("vcode_type", addPostResIdl.data.anti.vcode_type);
                    if (addPostResIdl.data.anti.vcode_extra != null) {
                        JSONObject jSONObject18 = new JSONObject();
                        jSONObject18.put("textimg", addPostResIdl.data.anti.vcode_extra.textimg);
                        jSONObject18.put("slideimg", addPostResIdl.data.anti.vcode_extra.slideimg);
                        jSONObject18.put(ContentUtil.RESULT_KEY_ENDPOINT, addPostResIdl.data.anti.vcode_extra.endpoint);
                        jSONObject18.put("successimg", addPostResIdl.data.anti.vcode_extra.successimg);
                        jSONObject18.put("slideendpoint", addPostResIdl.data.anti.vcode_extra.slideendpoint);
                        jSONObject17.put("vcode_extra", jSONObject18);
                    }
                    addPostHttpResponse.resultJSON.put(SubPbActivityConfig.KEY_ANTI, jSONObject17);
                }
                addPostHttpResponse.resultJSON.put("_ext_msg", addPostResIdl.data.ext_msg);
            }
            if (addPostResIdl.error != null) {
                JSONObject jSONObject19 = new JSONObject();
                jSONObject19.put("errno", addPostResIdl.error.errorno);
                jSONObject19.put("errmsg", addPostResIdl.error.errmsg);
                jSONObject19.put(VideoFinishResult.KEY_ERROR_USER_MSG, addPostResIdl.error.usermsg);
                addPostHttpResponse.resultJSON.put("error", jSONObject19);
            }
        }
    }
}
