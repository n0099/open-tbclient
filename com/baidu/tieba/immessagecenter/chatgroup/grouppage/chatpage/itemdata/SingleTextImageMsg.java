package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.messages.TextImageMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.nw5;
import com.baidu.tieba.q17;
import com.baidu.tieba.wf8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class SingleTextImageMsg extends BaseImageMsg<TextImageMsg> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_TYPE = 102;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @nw5(serialize = false)
    public CharSequence cacheText;
    @Nullable
    public BotsDTO.BotListDTO.SkillDTO.ItemsDTO fileItem;
    @Nullable
    @SerializedName("robot_params")
    public Map<String, Object> robotParams;
    @nw5(serialize = false)
    public String text;
    @nw5(serialize = false)
    public SpannableStringBuilder thumbnailText;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 102;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements q17.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleTextImageMsg a;

        public a(SingleTextImageMsg singleTextImageMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleTextImageMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = singleTextImageMsg;
        }

        @Override // com.baidu.tieba.q17.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) && this.a.thumbnailText.length() <= 0) {
                this.a.thumbnailText.append((CharSequence) spannableStringBuilder);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-496846488, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/SingleTextImageMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-496846488, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/SingleTextImageMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
    }

    public SingleTextImageMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Nullable
    public CharSequence getCacheText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.cacheText;
        }
        return (CharSequence) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.text;
            if (str != null) {
                this.text = str.replaceAll("\r", "\n");
            }
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.wn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public void onClearRedundancyFields(@NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
            super.onClearRedundancyFields(map);
            map.remove("fileItem");
            Map<String, Object> map2 = this.robotParams;
            if (map2 != null) {
                map.put("robot_params", map2);
            }
        }
    }

    public void setCacheText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, charSequence) == null) {
            this.cacheText = charSequence;
        }
    }

    public void setFileItem(@Nullable BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, itemsDTO) == null) {
            this.fileItem = itemsDTO;
        }
    }

    public void setRobotParams(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
            this.robotParams = map;
        }
    }

    @NonNull
    public static SingleTextImageMsg create(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            SingleTextImageMsg singleTextImageMsg = new SingleTextImageMsg();
            singleTextImageMsg.text = str;
            singleTextImageMsg.setThumbUrl(str2);
            singleTextImageMsg.setThumbSize(str3);
            singleTextImageMsg.setBigSize(str3);
            return singleTextImageMsg;
        }
        return (SingleTextImageMsg) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg
    public TextImageMsg createSdkMsgByChildClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TextImageMsg textImageMsg = new TextImageMsg();
            textImageMsg.setText(this.text);
            return textImageMsg;
        }
        return (TextImageMsg) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg
    public void fromSdkMsgToChildClass(@NonNull TextImageMsg textImageMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, textImageMsg) == null) {
            this.text = textImageMsg.getText();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SpannableStringBuilder spannableStringBuilder = this.thumbnailText;
            if (spannableStringBuilder != null) {
                return spannableStringBuilder;
            }
            this.thumbnailText = new SpannableStringBuilder();
            q17.e(TbadkApplication.getInst(), this.text, UtilHelper.getDimenPixelSize(R.dimen.T_X03), new a(this));
            if (this.thumbnailText.length() <= 0) {
                this.thumbnailText.append((CharSequence) this.text);
            }
            if (!StringUtils.isNull(this.thumbUrl)) {
                this.thumbnailText.append((CharSequence) this.IMG_THUMBNAIL_TEXT);
            }
            return this.thumbnailText;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg
    public void setSdkMsg(String str, String str2) {
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO;
        List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            super.setSdkMsg(str, str2);
            if (this.robotParams != null && (itemsDTO = this.fileItem) != null && itemsDTO.isFileType() && (opts = this.fileItem.getOpts()) != null && !opts.isEmpty() && (ext = opts.get(0).getExt()) != null) {
                ext.setPicPath(str2);
                wf8.o(this.robotParams, this.fileItem);
            }
        }
    }
}
