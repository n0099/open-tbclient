package com.baidu.tieba.sprite.funnysprite.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.cra;
import com.baidu.tieba.ei;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.mg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
/* loaded from: classes8.dex */
public class SpriteTipHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThemeColorInfo bgUrlTheme;
    public b buttonInfo;
    public int disappearSeconds;
    public int needSend;
    public int scene;
    public String sendText;
    public int speechType;
    public String spriteText;
    public String text;
    public ThemeColorInfo textColorTheme;
    public String version;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(SpriteTipHttpResponseMessage spriteTipHttpResponseMessage, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteTipHttpResponseMessage, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdResourceLoader.getInstance().loadResource(this.a, 59, null, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public String a;
        @Nullable
        public String b;

        public b() {
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

        @Nullable
        public static b a(@Nullable JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                b bVar = new b();
                bVar.a = jSONObject.optString("text");
                bVar.b = jSONObject.optString("schema");
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpriteTipHttpResponseMessage() {
        super(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
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
        this.disappearSeconds = -1;
    }

    private void preLoadBgUrl() {
        ThemeColorInfo themeColorInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, this) != null) || (themeColorInfo = this.bgUrlTheme) == null) {
            return;
        }
        String g = cra.g(themeColorInfo);
        if (!ei.isEmpty(g)) {
            mg.c(new a(this, g));
        }
    }

    public ThemeColorInfo getBgUrlTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bgUrlTheme;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public b getButtonInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.buttonInfo;
        }
        return (b) invokeV.objValue;
    }

    public int getDisappearSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.disappearSeconds;
        }
        return invokeV.intValue;
    }

    public boolean getNeedSend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.needSend != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.scene;
        }
        return invokeV.intValue;
    }

    public String getSendText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.sendText;
        }
        return (String) invokeV.objValue;
    }

    public int getSpeechType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.speechType;
        }
        return invokeV.intValue;
    }

    public String getSpriteText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.spriteText;
        }
        return (String) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    public ThemeColorInfo getTextColorTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.textColorTheme;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.version;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            String parseToString = parseToString(bArr);
            if (!TextUtils.isEmpty(parseToString)) {
                JSONObject jSONObject = new JSONObject(parseToString);
                setError(jSONObject.optInt("error_code", -1));
                setErrorString(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.scene = optJSONObject.optInt("scene");
                    this.text = optJSONObject.optString("text");
                    this.spriteText = optJSONObject.optString("sprite_text");
                    this.speechType = optJSONObject.optInt("speech_type");
                    this.needSend = optJSONObject.optInt("need_send");
                    this.sendText = optJSONObject.optString("send_text");
                    this.version = optJSONObject.optString("version");
                    this.disappearSeconds = optJSONObject.optInt("disappear_seconds", -1);
                    this.textColorTheme = cra.j(optJSONObject.optJSONObject(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR));
                    this.bgUrlTheme = cra.j(optJSONObject.optJSONObject("icon_url"));
                    this.buttonInfo = b.a(optJSONObject.optJSONObject("button_info"));
                    preLoadBgUrl();
                }
            }
        }
    }
}
