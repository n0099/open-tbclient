package com.baidu.tieba;

import android.widget.ListView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class so8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<ro8> a;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ListView a;
        public final /* synthetic */ List b;
        public final /* synthetic */ ro8 c;
        public final /* synthetic */ ChatMessage d;
        public final /* synthetic */ ChatMessage e;

        public a(so8 so8Var, ListView listView, List list, ro8 ro8Var, ChatMessage chatMessage, ChatMessage chatMessage2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so8Var, listView, list, ro8Var, chatMessage, chatMessage2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = listView;
            this.b = list;
            this.c = ro8Var;
            this.d = chatMessage;
            this.e = chatMessage2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.getLastVisiblePosition() != this.b.size() - 1) {
                return;
            }
            this.c.b(this.a, this.d, this.e);
        }
    }

    public so8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList<ro8> arrayList = new ArrayList<>(2);
        this.a = arrayList;
        arrayList.add(new qo8());
        this.a.add(new to8());
    }

    public void a(MsglistModel msglistModel, ListView listView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, msglistModel, listView) == null) && msglistModel != null && msglistModel.getData() != null) {
            List<ChatMessage> chatMessages = msglistModel.getData().getChatMessages();
            if (ListUtils.isEmpty(chatMessages)) {
                return;
            }
            ChatMessage chatMessage = (ChatMessage) ListUtils.getItem(chatMessages, ListUtils.getCount(chatMessages) - 1);
            ChatMessage chatMessage2 = (ChatMessage) ListUtils.getItem(chatMessages, ListUtils.getCount(chatMessages) - 2);
            Iterator<ro8> it = this.a.iterator();
            while (it.hasNext()) {
                ro8 next = it.next();
                if (next.a(chatMessage, chatMessage2)) {
                    listView.postDelayed(new a(this, listView, chatMessages, next, chatMessage, chatMessage2), 200L);
                    return;
                }
            }
        }
    }
}
