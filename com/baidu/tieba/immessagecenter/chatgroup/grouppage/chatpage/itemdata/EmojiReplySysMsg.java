package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hk8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class EmojiReplySysMsg extends BaseSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_TYPE = 20000;
    public static final long serialVersionUID = -2928652517766829057L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName(Constants.EXTRA_EMOJI_PACKAGE_ID)
    public String emojiPackageId;
    @SerializedName("emoji_reaction_list")
    public List<EmojiData> emojiSysDataList;
    @SerializedName("is_local")
    public boolean isLocal;
    @SerializedName("msg_id")
    public long oriEmojiRepliedMsgId;
    @SerializedName("msg_key")
    public String oriEmojiRepliedMsgKey;
    @SerializedName("msg_from_baidu_uk")
    public String oriEmojiRepliedMsgSenderBdUk;
    @SerializedName("react_type")
    public int reactType;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 20000;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Action.a<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiReplySysMsg a;

        public a(EmojiReplySysMsg emojiReplySysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiReplySysMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiReplySysMsg;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action.a
        @WorkerThread
        public void a(@NonNull Action.Op op, @Nullable BaseMsg baseMsg, @NonNull ChatMsgProcessor.j jVar) {
            CommonMsgField shallowClone;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLL(1048576, this, op, baseMsg, jVar) != null) || baseMsg == null || (shallowClone = baseMsg.getCommonMsgField().shallowClone()) == null) {
                return;
            }
            shallowClone.setIsLocal(this.a.isLocal);
            if (this.a.emojiSysDataList != null && this.a.emojiSysDataList.size() > 0) {
                EmojiReplySysMsg emojiReplySysMsg = this.a;
                emojiReplySysMsg.updateEmojiList(baseMsg, shallowClone, emojiReplySysMsg.emojiSysDataList, jVar);
                baseMsg.setCommonMsgField(shallowClone);
                return;
            }
            shallowClone.setEmojiList(new ArrayList());
            baseMsg.setCommonMsgField(shallowClone);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(947582731, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/EmojiReplySysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(947582731, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/EmojiReplySysMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
    }

    public EmojiReplySysMsg() {
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

    public List<EmojiData> getEmojiData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.emojiSysDataList;
        }
        return (List) invokeV.objValue;
    }

    public String getOriEmojiRepliedMsgSenderBdUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.oriEmojiRepliedMsgSenderBdUk;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.ym
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @Nullable
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Action.a(this.oriEmojiRepliedMsgId, this.oriEmojiRepliedMsgKey, Action.Op.UPDATE, new a(this));
        }
        return (Action) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void updateEmojiList(@NonNull BaseMsg baseMsg, @NonNull CommonMsgField commonMsgField, @NonNull List<EmojiData> list, @NonNull ChatMsgProcessor.j jVar) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, this, baseMsg, commonMsgField, list, jVar) == null) {
            if (jVar.b) {
                arrayList = new ArrayList(list);
            } else {
                List<EmojiData> emojiList = baseMsg.getCommonMsgField().getEmojiList();
                if (emojiList == null) {
                    arrayList = new ArrayList(list);
                } else {
                    ArrayList arrayList2 = new ArrayList(emojiList);
                    for (EmojiData emojiData : arrayList2) {
                        EmojiData b = hk8.b(emojiData.getContent(), list);
                        if (b != null) {
                            emojiData.setAllNum(b.getAllNum());
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (EmojiData emojiData2 : list) {
                        if (hk8.b(emojiData2.getContent(), arrayList2) == null) {
                            arrayList3.add(emojiData2);
                        }
                    }
                    arrayList2.addAll(arrayList3);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        if (hk8.b(((EmojiData) it.next()).getContent(), list) == null) {
                            it.remove();
                        }
                    }
                    arrayList = arrayList2;
                }
            }
            arrayList.add(new EmojiData("", commonMsgField.getMsgId(), commonMsgField.getMsgKey(), 0, 0L, Boolean.TRUE, 0));
            commonMsgField.setEmojiList(arrayList);
        }
    }
}
