package com.baidu.tieba.im.under.common.uiliststyle.group.item;

import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.uilist.Action;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbEmojiReplySysMsg;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.yi8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J4\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/EmojiReplySysItem;", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbEmojiReplySysMsg;", "()V", "getType", "Lcom/baidu/adp/BdUniqueId;", "provideAction", "Lcom/baidu/tieba/im/base/core/uilist/Action;", "updateEmojiList", "", "targetMsg", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "commonMsgField", "newList", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/EmojiData;", "source", "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$Source;", "Companion", "im-under-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmojiReplySysItem extends BaseItem<TbEmojiReplySysMsg> {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId ADAPTER_TYPE;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static final Pair<Integer, Class<EmojiReplySysItem>> parsePair() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Companion.a() : (Pair) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        @JvmStatic
        public final Pair<Integer, Class<EmojiReplySysItem>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Pair<>(20000, EmojiReplySysItem.class);
            }
            return (Pair) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Action.a<BaseItem<TbBaseMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiReplySysItem a;

        public b(EmojiReplySysItem emojiReplySysItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiReplySysItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiReplySysItem;
        }

        @Override // com.baidu.tieba.im.base.core.uilist.Action.a
        @WorkerThread
        public void a(Action.Op op, BaseItem<TbBaseMsg> baseItem, MsgProcessor.d source) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, op, baseItem, source) == null) {
                Intrinsics.checkNotNullParameter(op, "op");
                Intrinsics.checkNotNullParameter(source, "source");
                if (baseItem != null) {
                    TbBaseMsg tbMsg = baseItem.getTbMsg();
                    tbMsg.setLocalEmojiReply(source.f());
                    if (this.a.getTbMsg().getEmojiData() != null) {
                        List<EmojiData> emojiData = this.a.getTbMsg().getEmojiData();
                        Intrinsics.checkNotNull(emojiData);
                        if (emojiData.size() > 0) {
                            EmojiReplySysItem emojiReplySysItem = this.a;
                            List<EmojiData> emojiData2 = emojiReplySysItem.getTbMsg().getEmojiData();
                            Intrinsics.checkNotNull(emojiData2);
                            emojiReplySysItem.updateEmojiList(baseItem, tbMsg, emojiData2, source);
                            baseItem.injectTbMsg(tbMsg);
                            return;
                        }
                    }
                    tbMsg.setEmojiList(new ArrayList());
                    baseItem.injectTbMsg(tbMsg);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1730912331, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/EmojiReplySysItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1730912331, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/EmojiReplySysItem;");
                return;
            }
        }
        Companion = new a(null);
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        ADAPTER_TYPE = gen;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Action a2 = Action.a(getTbMsg().getOriEmojiRepliedMsgId(), getTbMsg().getOriEmojiRepliedMsgKey(), Action.Op.UPDATE, new b(this));
            Intrinsics.checkNotNullExpressionValue(a2, "override fun provideActi…\n                })\n    }");
            return a2;
        }
        return (Action) invokeV.objValue;
    }

    public EmojiReplySysItem() {
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

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, java.lang.Object
    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, com.baidu.tieba.yh
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void updateEmojiList(BaseItem<TbBaseMsg> baseItem, TbBaseMsg tbBaseMsg, List<EmojiData> list, MsgProcessor.d dVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, baseItem, tbBaseMsg, list, dVar) == null) {
            if (dVar.f()) {
                arrayList2 = new ArrayList(list);
            } else {
                if (baseItem.getTbMsg().getEmojiList() != null) {
                    List<EmojiData> emojiList = baseItem.getTbMsg().getEmojiList();
                    if (emojiList != null) {
                        arrayList = (ArrayList) emojiList;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.baidu.tieba.im.lib.socket.msg.data.EmojiData>");
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    arrayList2 = new ArrayList(list);
                } else {
                    ArrayList arrayList3 = new ArrayList(arrayList);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        EmojiData emojiData = (EmojiData) it.next();
                        EmojiData b2 = yi8.b(emojiData.getContent(), list);
                        if (b2 != null) {
                            emojiData.setAllNum(b2.getAllNum());
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (EmojiData emojiData2 : list) {
                        if (yi8.b(emojiData2.getContent(), arrayList3) == null) {
                            arrayList4.add(emojiData2);
                        }
                    }
                    arrayList3.addAll(arrayList4);
                    Iterator it2 = arrayList3.iterator();
                    Intrinsics.checkNotNullExpressionValue(it2, "emojiPayloader.iterator()");
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                        if (yi8.b(((EmojiData) next).getContent(), list) == null) {
                            it2.remove();
                        }
                    }
                    arrayList2 = arrayList3;
                }
            }
            arrayList2.add(new EmojiData("", tbBaseMsg.getMsgId(), tbBaseMsg.getMsgKey(), 0, 0L, Boolean.TRUE, 0));
            tbBaseMsg.setEmojiList(arrayList2);
        }
    }
}
