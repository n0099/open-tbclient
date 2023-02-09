package com.baidu.tieba.write.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.kh9;
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
import tbclient.Toast;
import tbclient.ToastConfig;
/* loaded from: classes6.dex */
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

    private void showToast(Toast toast) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, toast) != null) || toast == null) {
            return;
        }
        BdToastHelper.toast(kh9.a(toast));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String str;
        JSONObject json;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            AddPostHttpResponse addPostHttpResponse = this;
            AddPostResIdl addPostResIdl = (AddPostResIdl) new Wire(new Class[0]).parseFrom(bArr, AddPostResIdl.class);
            if (addPostResIdl == null) {
                return;
            }
            addPostHttpResponse.resultJSON = new JSONObject();
            DataRes dataRes = addPostResIdl.data;
            if (dataRes != null) {
                BdToastData a = kh9.a(dataRes.toast);
                if (a != null && (json = a.toJson()) != null) {
                    addPostHttpResponse.resultJSON.put("toast", json);
                }
                addPostHttpResponse.showToast(addPostResIdl.data.toast);
                addPostHttpResponse.resultJSON.put("opgroup", addPostResIdl.data.opgroup);
                addPostHttpResponse.resultJSON.put("tid", addPostResIdl.data.tid);
                addPostHttpResponse.resultJSON.put("pid", addPostResIdl.data.pid);
                addPostHttpResponse.resultJSON.put("video_id", addPostResIdl.data.video_id);
                addPostHttpResponse.resultJSON.put("msg", addPostResIdl.data.msg);
                addPostHttpResponse.resultJSON.put("pre_msg", addPostResIdl.data.pre_msg);
                addPostHttpResponse.resultJSON.put("color_msg", addPostResIdl.data.color_msg);
                if (addPostResIdl.data.twzhibo_info != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("is_copytwzhibo", addPostResIdl.data.twzhibo_info.is_copytwzhibo);
                    addPostHttpResponse.resultJSON.put("twzhibo_info", jSONObject);
                }
                if (addPostResIdl.data.exp != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("pre_msg", addPostResIdl.data.exp.pre_msg);
                    jSONObject2.put("color_msg", addPostResIdl.data.exp.color_msg);
                    jSONObject2.put("current_level_max_exp", addPostResIdl.data.exp.current_level_max_exp);
                    jSONObject2.put("current_level", addPostResIdl.data.exp.current_level);
                    jSONObject2.put("old", addPostResIdl.data.exp.old);
                    jSONObject2.put("inc", addPostResIdl.data.exp.inc);
                    jSONObject2.put("question_exp", addPostResIdl.data.exp.question_exp);
                    jSONObject2.put("question_msg", addPostResIdl.data.exp.question_msg);
                    addPostHttpResponse.resultJSON.put("exp", jSONObject2);
                }
                if (addPostResIdl.data.contri_info != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("color_msg", addPostResIdl.data.contri_info.color_msg);
                    jSONObject3.put("after_msg", addPostResIdl.data.contri_info.after_msg);
                    List<ToastConfig> list = addPostResIdl.data.contri_info.toast_config;
                    if (list != null) {
                        JSONArray jSONArray = new JSONArray();
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            ToastConfig toastConfig = list.get(i2);
                            if (toastConfig != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("pre_color_msg", toastConfig.pre_color_msg);
                                jSONObject4.put("toast_back_image", toastConfig.toast_back_image);
                                jSONArray.put(jSONObject4);
                            }
                        }
                        jSONObject3.put("toast_config", jSONArray);
                    }
                    addPostHttpResponse.resultJSON.put("contri_info", jSONObject3);
                }
                if (addPostResIdl.data.star_info != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("activity_id", addPostResIdl.data.star_info.activity_id);
                    jSONObject5.put("video_url", addPostResIdl.data.star_info.video_url);
                    jSONObject5.put("pop_text", addPostResIdl.data.star_info.pop_text);
                    jSONObject5.put("pop_imageurl", addPostResIdl.data.star_info.pop_imageurl);
                    if (addPostResIdl.data.star_info.share_info != null) {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("title", addPostResIdl.data.star_info.share_info.title);
                        jSONObject6.put("content", addPostResIdl.data.star_info.share_info.content);
                        jSONObject6.put("url", addPostResIdl.data.star_info.share_info.url);
                        jSONObject6.put("imageurl", addPostResIdl.data.star_info.share_info.imageurl);
                        jSONObject5.put("share_info", jSONObject6);
                    }
                    addPostHttpResponse.resultJSON.put("star_info", jSONObject5);
                }
                if (addPostResIdl.data.advertisement != null) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("pic", addPostResIdl.data.advertisement.pic);
                    jSONObject7.put("pic_click", addPostResIdl.data.advertisement.pic_click);
                    jSONObject7.put("jump_link", addPostResIdl.data.advertisement.jump_link);
                    jSONObject7.put("advertisement_id", addPostResIdl.data.advertisement.advertisement_id);
                    jSONObject7.put("view_statistics_url", addPostResIdl.data.advertisement.view_statistics_url);
                    jSONObject7.put("click_statistics_url", addPostResIdl.data.advertisement.click_statistics_url);
                    jSONObject7.put("floating_text", addPostResIdl.data.advertisement.floating_text);
                    jSONObject7.put("scheme", addPostResIdl.data.advertisement.scheme);
                    jSONObject7.put("package_name", addPostResIdl.data.advertisement.package_name);
                    jSONObject7.put("display_ad_icon", addPostResIdl.data.advertisement.display_ad_icon);
                    addPostHttpResponse.resultJSON.put("advertisement", jSONObject7);
                }
                if (addPostResIdl.data.icon_stamp_info != null) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("stamp_title", addPostResIdl.data.icon_stamp_info.stamp_title);
                    jSONObject8.put("stamp_text", addPostResIdl.data.icon_stamp_info.stamp_text);
                    jSONObject8.put("stamp_type", addPostResIdl.data.icon_stamp_info.stamp_type);
                    addPostHttpResponse.resultJSON.put("icon_stamp_info", jSONObject8);
                }
                if (addPostResIdl.data.info == null) {
                    str = "content";
                } else {
                    JSONObject jSONObject9 = new JSONObject();
                    if (addPostResIdl.data.info.access_state == null) {
                        str = "content";
                    } else {
                        JSONObject jSONObject10 = new JSONObject();
                        str = "content";
                        jSONObject10.put("type", addPostResIdl.data.info.access_state.type);
                        jSONObject10.put("token", addPostResIdl.data.info.access_state.token);
                        if (addPostResIdl.data.info.access_state.userinfo != null) {
                            JSONObject jSONObject11 = new JSONObject();
                            jSONObject11.put("bduss", addPostResIdl.data.info.access_state.userinfo.bduss);
                            jSONObject11.put("strMobile", addPostResIdl.data.info.access_state.userinfo.mobile);
                            jSONObject11.put("strEmail", addPostResIdl.data.info.access_state.userinfo.email);
                            jSONObject10.put(TableDefine.DB_TABLE_USERINFO, jSONObject11);
                        }
                        jSONObject9.put(AccountAccessActivityConfig.KEY_ACCESS_STATE, jSONObject10);
                    }
                    if (addPostResIdl.data.info.confilter_hitwords != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i3 = 0; i3 < addPostResIdl.data.info.confilter_hitwords.size(); i3++) {
                            jSONArray2.put(addPostResIdl.data.info.confilter_hitwords.get(i3));
                        }
                        jSONObject9.put("confilter_hitwords", jSONArray2);
                    }
                    jSONObject9.put("need_vcode", addPostResIdl.data.info.need_vcode);
                    jSONObject9.put("vcode_md5", addPostResIdl.data.info.vcode_md5);
                    jSONObject9.put("vcode_prev_type", addPostResIdl.data.info.vcode_prev_type);
                    jSONObject9.put("vcode_type", addPostResIdl.data.info.vcode_type);
                    jSONObject9.put("pass_token", addPostResIdl.data.info.pass_token);
                    jSONObject9.put("block_content", addPostResIdl.data.info.block_content);
                    jSONObject9.put("block_cancel", addPostResIdl.data.info.block_cancel);
                    jSONObject9.put("block_confirm", addPostResIdl.data.info.block_confirm);
                    jSONObject9.put("vcode_pic_url", addPostResIdl.data.info.vcode_pic_url);
                    if (addPostResIdl.data.info.vcode_extra != null) {
                        JSONObject jSONObject12 = new JSONObject();
                        jSONObject12.put("textimg", addPostResIdl.data.info.vcode_extra.textimg);
                        jSONObject12.put("slideimg", addPostResIdl.data.info.vcode_extra.slideimg);
                        jSONObject12.put(ContentUtil.RESULT_KEY_ENDPOINT, addPostResIdl.data.info.vcode_extra.endpoint);
                        jSONObject12.put("successimg", addPostResIdl.data.info.vcode_extra.successimg);
                        jSONObject12.put("slideendpoint", addPostResIdl.data.info.vcode_extra.slideendpoint);
                        jSONObject9.put("vcode_extra", jSONObject12);
                    }
                    addPostHttpResponse = this;
                    addPostHttpResponse.resultJSON.put("info", jSONObject9);
                }
                if (addPostResIdl.data.anti_stat != null) {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("ifpost", addPostResIdl.data.anti_stat.ifpost);
                    jSONObject13.put("ifposta", addPostResIdl.data.anti_stat.ifposta);
                    jSONObject13.put("forbid_flag", addPostResIdl.data.anti_stat.forbid_flag);
                    jSONObject13.put(HttpRequest.TBS, addPostResIdl.data.anti_stat.tbs);
                    jSONObject13.put("need_vcode", addPostResIdl.data.anti_stat.need_vcode);
                    jSONObject13.put("vcode_md5", addPostResIdl.data.anti_stat.vcode_md5);
                    jSONObject13.put("vcode_pic_url", addPostResIdl.data.anti_stat.vcode_pic_url);
                    jSONObject13.put("forbid_info", addPostResIdl.data.anti_stat.forbid_info);
                    jSONObject13.put("ifvoice", addPostResIdl.data.anti_stat.ifvoice);
                    jSONObject13.put("voice_message", addPostResIdl.data.anti_stat.voice_message);
                    jSONObject13.put("block_stat", addPostResIdl.data.anti_stat.block_stat);
                    jSONObject13.put("hide_stat", addPostResIdl.data.anti_stat.hide_stat);
                    jSONObject13.put("vcode_stat", addPostResIdl.data.anti_stat.vcode_stat);
                    jSONObject13.put("days_tofree", addPostResIdl.data.anti_stat.days_tofree);
                    jSONObject13.put("has_chance", addPostResIdl.data.anti_stat.has_chance);
                    jSONObject13.put("ifaddition", addPostResIdl.data.anti_stat.ifaddition);
                    jSONObject13.put("poll_message", addPostResIdl.data.anti_stat.poll_message);
                    jSONObject13.put("video_message", addPostResIdl.data.anti_stat.video_message);
                    if (addPostResIdl.data.anti_stat.block_pop_info != null) {
                        JSONObject jSONObject14 = new JSONObject();
                        jSONObject14.put("ahead_info", addPostResIdl.data.anti_stat.block_pop_info.ahead_info);
                        jSONObject14.put("ahead_url", addPostResIdl.data.anti_stat.block_pop_info.ahead_url);
                        jSONObject14.put("ok_info", addPostResIdl.data.anti_stat.block_pop_info.ok_info);
                        jSONObject14.put("can_post", addPostResIdl.data.anti_stat.block_pop_info.can_post);
                        jSONObject14.put("block_info", addPostResIdl.data.anti_stat.block_pop_info.block_info);
                        jSONObject14.put("sub_block_info", addPostResIdl.data.anti_stat.block_pop_info.sub_block_info);
                        jSONObject14.put("ahead_type", addPostResIdl.data.anti_stat.block_pop_info.ahead_type);
                        jSONObject13.put("block_pop_info", jSONObject14);
                    }
                    jSONObject13.put("reply_private_flag", addPostResIdl.data.anti_stat.reply_private_flag);
                    jSONObject13.put("poll_level", addPostResIdl.data.anti_stat.poll_level);
                    jSONObject13.put("is_sexyforum", addPostResIdl.data.anti_stat.is_sexyforum);
                    jSONObject13.put("teenmode_interval", addPostResIdl.data.anti_stat.teenmode_interval);
                    addPostHttpResponse.resultJSON.put("anti_stat", jSONObject13);
                }
                if (addPostResIdl.data.tb_hudong != null) {
                    JSONObject jSONObject15 = new JSONObject();
                    jSONObject15.put(str, addPostResIdl.data.tb_hudong.content);
                    addPostHttpResponse.resultJSON.put("tb_hudong", jSONObject15);
                }
                if (addPostResIdl.data.anti != null) {
                    JSONObject jSONObject16 = new JSONObject();
                    jSONObject16.put("vcode_md5", addPostResIdl.data.anti.vcode_md5);
                    jSONObject16.put("vcode_pic_url", addPostResIdl.data.anti.vcode_pic_url);
                    jSONObject16.put("vcode_type", addPostResIdl.data.anti.vcode_type);
                    if (addPostResIdl.data.anti.vcode_extra != null) {
                        JSONObject jSONObject17 = new JSONObject();
                        jSONObject17.put("textimg", addPostResIdl.data.anti.vcode_extra.textimg);
                        jSONObject17.put("slideimg", addPostResIdl.data.anti.vcode_extra.slideimg);
                        jSONObject17.put(ContentUtil.RESULT_KEY_ENDPOINT, addPostResIdl.data.anti.vcode_extra.endpoint);
                        jSONObject17.put("successimg", addPostResIdl.data.anti.vcode_extra.successimg);
                        jSONObject17.put("slideendpoint", addPostResIdl.data.anti.vcode_extra.slideendpoint);
                        jSONObject16.put("vcode_extra", jSONObject17);
                    }
                    addPostHttpResponse.resultJSON.put(SubPbActivityConfig.KEY_ANTI, jSONObject16);
                }
                addPostHttpResponse.resultJSON.put("_ext_msg", addPostResIdl.data.ext_msg);
            }
            if (addPostResIdl.error != null) {
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("errno", addPostResIdl.error.errorno);
                jSONObject18.put("errmsg", addPostResIdl.error.errmsg);
                jSONObject18.put(VideoFinishResult.KEY_ERROR_USER_MSG, addPostResIdl.error.usermsg);
                addPostHttpResponse.resultJSON.put("error", jSONObject18);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public JSONObject getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.resultJSON;
        }
        return (JSONObject) invokeV.objValue;
    }
}
