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
import tbclient.AddThread.AddThreadResIdl;
import tbclient.AddThread.DataRes;
import tbclient.ToastConfig;
/* loaded from: classes4.dex */
public class AddThreadHttpResponse extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String resultData;
    public JSONObject resultJSON;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddThreadHttpResponse(int i) {
        super(CmdConfigHttp.CMD_WRITE_THREAD_ADD);
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
            AddThreadHttpResponse addThreadHttpResponse = this;
            AddThreadResIdl addThreadResIdl = (AddThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, AddThreadResIdl.class);
            if (addThreadResIdl == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            addThreadHttpResponse.resultJSON = jSONObject;
            DataRes dataRes = addThreadResIdl.data;
            if (dataRes != null) {
                jSONObject.put("opgroup", dataRes.opgroup);
                addThreadHttpResponse.resultJSON.put("tid", addThreadResIdl.data.tid);
                addThreadHttpResponse.resultJSON.put("pid", addThreadResIdl.data.pid);
                addThreadHttpResponse.resultJSON.put("video_id", addThreadResIdl.data.video_id);
                addThreadHttpResponse.resultJSON.put("msg", addThreadResIdl.data.msg);
                addThreadHttpResponse.resultJSON.put("pre_msg", addThreadResIdl.data.pre_msg);
                addThreadHttpResponse.resultJSON.put("color_msg", addThreadResIdl.data.color_msg);
                if (addThreadResIdl.data.twzhibo_info != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("is_copytwzhibo", addThreadResIdl.data.twzhibo_info.is_copytwzhibo);
                    addThreadHttpResponse.resultJSON.put("twzhibo_info", jSONObject2);
                }
                if (addThreadResIdl.data.exp != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("pre_msg", addThreadResIdl.data.exp.pre_msg);
                    jSONObject3.put("color_msg", addThreadResIdl.data.exp.color_msg);
                    jSONObject3.put("current_level_max_exp", addThreadResIdl.data.exp.current_level_max_exp);
                    jSONObject3.put("current_level", addThreadResIdl.data.exp.current_level);
                    jSONObject3.put("old", addThreadResIdl.data.exp.old);
                    jSONObject3.put("inc", addThreadResIdl.data.exp.inc);
                    addThreadHttpResponse.resultJSON.put("exp", jSONObject3);
                }
                if (addThreadResIdl.data.contri_info != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("color_msg", addThreadResIdl.data.contri_info.color_msg);
                    jSONObject4.put("after_msg", addThreadResIdl.data.contri_info.after_msg);
                    List<ToastConfig> list = addThreadResIdl.data.contri_info.toast_config;
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
                    addThreadHttpResponse.resultJSON.put("contri_info", jSONObject4);
                }
                if (addThreadResIdl.data.star_info != null) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("activity_id", addThreadResIdl.data.star_info.activity_id);
                    jSONObject6.put("video_url", addThreadResIdl.data.star_info.video_url);
                    jSONObject6.put("pop_text", addThreadResIdl.data.star_info.pop_text);
                    jSONObject6.put("pop_imageurl", addThreadResIdl.data.star_info.pop_imageurl);
                    if (addThreadResIdl.data.star_info.share_info != null) {
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("title", addThreadResIdl.data.star_info.share_info.title);
                        jSONObject7.put("content", addThreadResIdl.data.star_info.share_info.content);
                        jSONObject7.put("url", addThreadResIdl.data.star_info.share_info.url);
                        jSONObject7.put("imageurl", addThreadResIdl.data.star_info.share_info.imageurl);
                        jSONObject6.put("share_info", jSONObject7);
                    }
                    addThreadHttpResponse.resultJSON.put("star_info", jSONObject6);
                }
                if (addThreadResIdl.data.advertisement != null) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("pic", addThreadResIdl.data.advertisement.pic);
                    jSONObject8.put("pic_click", addThreadResIdl.data.advertisement.pic_click);
                    jSONObject8.put("jump_link", addThreadResIdl.data.advertisement.jump_link);
                    jSONObject8.put("advertisement_id", addThreadResIdl.data.advertisement.advertisement_id);
                    jSONObject8.put("view_statistics_url", addThreadResIdl.data.advertisement.view_statistics_url);
                    jSONObject8.put("click_statistics_url", addThreadResIdl.data.advertisement.click_statistics_url);
                    jSONObject8.put("floating_text", addThreadResIdl.data.advertisement.floating_text);
                    jSONObject8.put("scheme", addThreadResIdl.data.advertisement.scheme);
                    jSONObject8.put("package_name", addThreadResIdl.data.advertisement.package_name);
                    jSONObject8.put("display_ad_icon", addThreadResIdl.data.advertisement.display_ad_icon);
                    addThreadHttpResponse.resultJSON.put("advertisement", jSONObject8);
                }
                if (addThreadResIdl.data.icon_stamp_info != null) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("stamp_title", addThreadResIdl.data.icon_stamp_info.stamp_title);
                    jSONObject9.put("stamp_text", addThreadResIdl.data.icon_stamp_info.stamp_text);
                    jSONObject9.put("stamp_type", addThreadResIdl.data.icon_stamp_info.stamp_type);
                    addThreadHttpResponse.resultJSON.put("icon_stamp_info", jSONObject9);
                }
                if (addThreadResIdl.data.info != null) {
                    JSONObject jSONObject10 = new JSONObject();
                    if (addThreadResIdl.data.info.access_state != null) {
                        JSONObject jSONObject11 = new JSONObject();
                        str = "content";
                        jSONObject11.put("type", addThreadResIdl.data.info.access_state.type);
                        jSONObject11.put("token", addThreadResIdl.data.info.access_state.token);
                        if (addThreadResIdl.data.info.access_state.userinfo != null) {
                            JSONObject jSONObject12 = new JSONObject();
                            jSONObject12.put("bduss", addThreadResIdl.data.info.access_state.userinfo.bduss);
                            jSONObject12.put("strMobile", addThreadResIdl.data.info.access_state.userinfo.mobile);
                            jSONObject12.put("strEmail", addThreadResIdl.data.info.access_state.userinfo.email);
                            jSONObject11.put(TableDefine.DB_TABLE_USERINFO, jSONObject12);
                        }
                        jSONObject10.put(AccountAccessActivityConfig.KEY_ACCESS_STATE, jSONObject11);
                    } else {
                        str = "content";
                    }
                    if (addThreadResIdl.data.info.confilter_hitwords != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i3 = 0; i3 < addThreadResIdl.data.info.confilter_hitwords.size(); i3++) {
                            jSONArray2.put(addThreadResIdl.data.info.confilter_hitwords.get(i3));
                        }
                        jSONObject10.put("confilter_hitwords", jSONArray2);
                    }
                    jSONObject10.put("need_vcode", addThreadResIdl.data.info.need_vcode);
                    jSONObject10.put("vcode_md5", addThreadResIdl.data.info.vcode_md5);
                    jSONObject10.put("vcode_prev_type", addThreadResIdl.data.info.vcode_prev_type);
                    jSONObject10.put("vcode_type", addThreadResIdl.data.info.vcode_type);
                    jSONObject10.put("pass_token", addThreadResIdl.data.info.pass_token);
                    jSONObject10.put("block_content", addThreadResIdl.data.info.block_content);
                    jSONObject10.put("block_cancel", addThreadResIdl.data.info.block_cancel);
                    jSONObject10.put("block_confirm", addThreadResIdl.data.info.block_confirm);
                    jSONObject10.put("vcode_pic_url", addThreadResIdl.data.info.vcode_pic_url);
                    if (addThreadResIdl.data.info.vcode_extra != null) {
                        JSONObject jSONObject13 = new JSONObject();
                        jSONObject13.put("textimg", addThreadResIdl.data.info.vcode_extra.textimg);
                        jSONObject13.put("slideimg", addThreadResIdl.data.info.vcode_extra.slideimg);
                        jSONObject13.put(ContentUtil.RESULT_KEY_ENDPOINT, addThreadResIdl.data.info.vcode_extra.endpoint);
                        jSONObject13.put("successimg", addThreadResIdl.data.info.vcode_extra.successimg);
                        jSONObject13.put("slideendpoint", addThreadResIdl.data.info.vcode_extra.slideendpoint);
                        jSONObject10.put("vcode_extra", jSONObject13);
                    }
                    addThreadHttpResponse = this;
                    addThreadHttpResponse.resultJSON.put("info", jSONObject10);
                } else {
                    str = "content";
                }
                if (addThreadResIdl.data.anti_stat != null) {
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("ifpost", addThreadResIdl.data.anti_stat.ifpost);
                    jSONObject14.put("ifposta", addThreadResIdl.data.anti_stat.ifposta);
                    jSONObject14.put("forbid_flag", addThreadResIdl.data.anti_stat.forbid_flag);
                    jSONObject14.put(HttpRequest.TBS, addThreadResIdl.data.anti_stat.tbs);
                    jSONObject14.put("need_vcode", addThreadResIdl.data.anti_stat.need_vcode);
                    jSONObject14.put("vcode_md5", addThreadResIdl.data.anti_stat.vcode_md5);
                    jSONObject14.put("vcode_pic_url", addThreadResIdl.data.anti_stat.vcode_pic_url);
                    jSONObject14.put("forbid_info", addThreadResIdl.data.anti_stat.forbid_info);
                    jSONObject14.put("ifvoice", addThreadResIdl.data.anti_stat.ifvoice);
                    jSONObject14.put("voice_message", addThreadResIdl.data.anti_stat.voice_message);
                    jSONObject14.put("block_stat", addThreadResIdl.data.anti_stat.block_stat);
                    jSONObject14.put("hide_stat", addThreadResIdl.data.anti_stat.hide_stat);
                    jSONObject14.put("vcode_stat", addThreadResIdl.data.anti_stat.vcode_stat);
                    jSONObject14.put("days_tofree", addThreadResIdl.data.anti_stat.days_tofree);
                    jSONObject14.put("has_chance", addThreadResIdl.data.anti_stat.has_chance);
                    jSONObject14.put("ifaddition", addThreadResIdl.data.anti_stat.ifaddition);
                    jSONObject14.put("poll_message", addThreadResIdl.data.anti_stat.poll_message);
                    jSONObject14.put("video_message", addThreadResIdl.data.anti_stat.video_message);
                    if (addThreadResIdl.data.anti_stat.block_pop_info != null) {
                        JSONObject jSONObject15 = new JSONObject();
                        jSONObject15.put("ahead_info", addThreadResIdl.data.anti_stat.block_pop_info.ahead_info);
                        jSONObject15.put("ahead_url", addThreadResIdl.data.anti_stat.block_pop_info.ahead_url);
                        jSONObject15.put("ok_info", addThreadResIdl.data.anti_stat.block_pop_info.ok_info);
                        jSONObject15.put("can_post", addThreadResIdl.data.anti_stat.block_pop_info.can_post);
                        jSONObject15.put("block_info", addThreadResIdl.data.anti_stat.block_pop_info.block_info);
                        jSONObject15.put("sub_block_info", addThreadResIdl.data.anti_stat.block_pop_info.sub_block_info);
                        jSONObject15.put("ahead_type", addThreadResIdl.data.anti_stat.block_pop_info.ahead_type);
                        jSONObject14.put("block_pop_info", jSONObject15);
                    }
                    jSONObject14.put("reply_private_flag", addThreadResIdl.data.anti_stat.reply_private_flag);
                    jSONObject14.put("poll_level", addThreadResIdl.data.anti_stat.poll_level);
                    jSONObject14.put("is_sexyforum", addThreadResIdl.data.anti_stat.is_sexyforum);
                    jSONObject14.put("teenmode_interval", addThreadResIdl.data.anti_stat.teenmode_interval);
                    addThreadHttpResponse.resultJSON.put("anti_stat", jSONObject14);
                }
                if (addThreadResIdl.data.tb_hudong != null) {
                    JSONObject jSONObject16 = new JSONObject();
                    jSONObject16.put(str, addThreadResIdl.data.tb_hudong.content);
                    addThreadHttpResponse.resultJSON.put("tb_hudong", jSONObject16);
                }
                if (addThreadResIdl.data.anti != null) {
                    JSONObject jSONObject17 = new JSONObject();
                    jSONObject17.put("vcode_md5", addThreadResIdl.data.anti.vcode_md5);
                    jSONObject17.put("vcode_pic_url", addThreadResIdl.data.anti.vcode_pic_url);
                    jSONObject17.put("vcode_type", addThreadResIdl.data.anti.vcode_type);
                    if (addThreadResIdl.data.anti.vcode_extra != null) {
                        JSONObject jSONObject18 = new JSONObject();
                        jSONObject18.put("textimg", addThreadResIdl.data.anti.vcode_extra.textimg);
                        jSONObject18.put("slideimg", addThreadResIdl.data.anti.vcode_extra.slideimg);
                        jSONObject18.put(ContentUtil.RESULT_KEY_ENDPOINT, addThreadResIdl.data.anti.vcode_extra.endpoint);
                        jSONObject18.put("successimg", addThreadResIdl.data.anti.vcode_extra.successimg);
                        jSONObject18.put("slideendpoint", addThreadResIdl.data.anti.vcode_extra.slideendpoint);
                        jSONObject17.put("vcode_extra", jSONObject18);
                    }
                    addThreadHttpResponse.resultJSON.put(SubPbActivityConfig.KEY_ANTI, jSONObject17);
                }
                addThreadHttpResponse.resultJSON.put("_ext_msg", addThreadResIdl.data.ext_msg);
            }
            if (addThreadResIdl.error != null) {
                JSONObject jSONObject19 = new JSONObject();
                jSONObject19.put("errno", addThreadResIdl.error.errorno);
                jSONObject19.put("errmsg", addThreadResIdl.error.errmsg);
                jSONObject19.put(VideoFinishResult.KEY_ERROR_USER_MSG, addThreadResIdl.error.usermsg);
                addThreadHttpResponse.resultJSON.put("error", jSONObject19);
            }
        }
    }
}
