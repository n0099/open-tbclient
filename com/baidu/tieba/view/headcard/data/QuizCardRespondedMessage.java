package com.baidu.tieba.view.headcard.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.t6b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.QuizInfo;
import tbclient.QuizOption;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/view/headcard/data/QuizCardRespondedMessage;", "Lcom/baidu/tbadk/message/http/JsonHttpResponsedMessage;", "()V", "dialogData", "Lcom/baidu/tieba/view/headcard/data/RaceGuessingDialogData;", "getDialogData", "()Lcom/baidu/tieba/view/headcard/data/RaceGuessingDialogData;", "setDialogData", "(Lcom/baidu/tieba/view/headcard/data/RaceGuessingDialogData;)V", "quizInfo", "Ltbclient/QuizInfo;", "getQuizInfo", "()Ltbclient/QuizInfo;", "setQuizInfo", "(Ltbclient/QuizInfo;)V", "decodeLogicInBackGround", "", "cmd", "", "retJson", "Lorg/json/JSONObject;", "parseDialogData", "parseQuizData", "QuizErrorData", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class QuizCardRespondedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t6b dialogData;
    public QuizInfo quizInfo;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("activity_page_url")
        public String a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuizCardRespondedMessage() {
        super(CmdConfigHttp.CMD_HTTP_FORUM_QUIZ_CARD_RESULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final t6b getDialogData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dialogData;
        }
        return (t6b) invokeV.objValue;
    }

    public final QuizInfo getQuizInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.quizInfo;
        }
        return (QuizInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        JSONObject data;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null && (data = jSONObject.optJSONObject("data")) != null) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                parseDialogData(data);
                parseQuizData(data);
            }
        }
    }

    public final void parseDialogData(JSONObject retJson) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, retJson) == null) {
            Intrinsics.checkNotNullParameter(retJson, "retJson");
            JSONObject optJSONObject = retJson.optJSONObject("popup_dialog");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("content")) != null && optJSONArray.length() >= 3) {
                this.dialogData = new t6b();
                JSONObject titleObj = optJSONArray.optJSONObject(0);
                if (titleObj != null) {
                    Intrinsics.checkNotNullExpressionValue(titleObj, "titleObj");
                    t6b t6bVar = this.dialogData;
                    if (t6bVar != null) {
                        t6bVar.d(titleObj.optString("text"));
                    }
                }
                ArrayList<t6b.a> arrayList = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 1; i < length; i++) {
                    JSONObject contentObj = optJSONArray.optJSONObject(i);
                    if (contentObj != null) {
                        Intrinsics.checkNotNullExpressionValue(contentObj, "contentObj");
                        t6b.a aVar = new t6b.a();
                        aVar.f(contentObj.optString("text"));
                        aVar.e(contentObj.optInt("has_color"));
                        aVar.g(contentObj.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR));
                        aVar.h(contentObj.optString("text_color_dark"));
                        arrayList.add(aVar);
                    }
                }
                t6b t6bVar2 = this.dialogData;
                if (t6bVar2 != null) {
                    t6bVar2.c(arrayList);
                }
            }
        }
    }

    public final void parseQuizData(JSONObject retJson) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, retJson) == null) {
            Intrinsics.checkNotNullParameter(retJson, "retJson");
            JSONObject optJSONObject = retJson.optJSONObject("quiz");
            if (optJSONObject != null) {
                QuizInfo.Builder builder = new QuizInfo.Builder();
                builder.bonus_type = Long.valueOf(optJSONObject.optLong("bonus_type"));
                builder.browse_user_option = Long.valueOf(optJSONObject.optLong("browse_user_option"));
                builder.total_count_icon = optJSONObject.optString("total_count_icon");
                builder.total_count_text = optJSONObject.optString("total_count_text");
                builder.quiz_id = Long.valueOf(optJSONObject.optLong("quiz_id"));
                builder.product = Long.valueOf(optJSONObject.optLong("product"));
                builder.title = optJSONObject.optString("title");
                builder.min_pour_count = Long.valueOf(optJSONObject.optLong("min_pour_count"));
                builder.total_count = Long.valueOf(optJSONObject.optLong("total_count"));
                builder.total_user_count = Long.valueOf(optJSONObject.optLong("total_user_count"));
                builder.type = Long.valueOf(optJSONObject.optLong("type"));
                JSONArray optionsArray = optJSONObject.optJSONArray("options");
                ArrayList arrayList = null;
                if (optionsArray != null) {
                    Intrinsics.checkNotNullExpressionValue(optionsArray, "optionsArray");
                    arrayList = new ArrayList();
                    int length = optionsArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optionsObj = optionsArray.optJSONObject(i);
                        if (optionsObj != null) {
                            Intrinsics.checkNotNullExpressionValue(optionsObj, "optionsObj");
                            QuizOption.Builder builder2 = new QuizOption.Builder();
                            builder2.quiz_option_id = Long.valueOf(optionsObj.optLong("quiz_option_id"));
                            builder2.quiz_option = optionsObj.optString("quiz_option");
                            builder2.icon = optionsObj.optString("icon");
                            builder2.total_user_count = Long.valueOf(optionsObj.optLong("total_user_count"));
                            builder2.button_img = optionsObj.optString("button_img");
                            builder2.button_text_sup = optionsObj.optString("button_text_sup");
                            builder2.button_text_no = optionsObj.optString("button_text_no");
                            QuizOption build = builder2.build(true);
                            Intrinsics.checkNotNullExpressionValue(build, "optionBuilder.build(true)");
                            arrayList.add(build);
                        }
                    }
                }
                builder.options = arrayList;
                this.quizInfo = builder.build(true);
            }
        }
    }

    public final void setDialogData(t6b t6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t6bVar) == null) {
            this.dialogData = t6bVar;
        }
    }

    public final void setQuizInfo(QuizInfo quizInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, quizInfo) == null) {
            this.quizInfo = quizInfo;
        }
    }
}
