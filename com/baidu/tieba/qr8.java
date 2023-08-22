package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.emoji.ImEmojiUtil;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class qr8 implements or8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Integer> a;

    public qr8() {
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
        HashMap<String, Integer> hashMap = new HashMap<>(3);
        this.a = hashMap;
        hashMap.put("#(滑稽)", Integer.valueOf(ImEmojiUtil.a));
        this.a.put("#(香槟)", Integer.valueOf(ImEmojiUtil.b));
        this.a.put("#(炸药)", Integer.valueOf(ImEmojiUtil.c));
    }

    @Override // com.baidu.tieba.or8
    public boolean a(ChatMessage... chatMessageArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatMessageArr)) == null) {
            return this.a.containsKey(c(chatMessageArr));
        }
        return invokeL.booleanValue;
    }

    public final String c(ChatMessage... chatMessageArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessageArr)) == null) {
            if (chatMessageArr != null && chatMessageArr.length > 0 && chatMessageArr[0] != null) {
                return chatMessageArr[0].getContent();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.or8
    public void b(ListView listView, ChatMessage... chatMessageArr) {
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listView, chatMessageArr) != null) || listView == null || (childAt = listView.getChildAt(listView.getLastVisiblePosition() - listView.getFirstVisiblePosition())) == null) {
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.tex_msgitem_text);
        if (chatMessageArr != null && chatMessageArr.length > 1) {
            ImEmojiUtil.m(listView.getContext(), (FrameLayout) listView.getRootView().findViewById(16908290), this.a.get(c(chatMessageArr)).intValue(), tbRichTextView, null);
        }
    }
}
