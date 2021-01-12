package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.MultiGraphicTextMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.android.imsdk.chatmessage.messages.SmartMsg;
import com.baidu.android.imsdk.chatmessage.messages.TempletMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
/* loaded from: classes10.dex */
public class b {
    private static volatile b oNG;

    /* loaded from: classes10.dex */
    public interface a {
        void a(View view, int i, ChatMsg chatMsg);
    }

    public static synchronized b hr(Context context) {
        b bVar;
        synchronized (b.class) {
            if (oNG == null) {
                oNG = new b();
            }
            bVar = oNG;
        }
        return bVar;
    }

    public e a(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        w r;
        switch (chatMsg.getMsgType()) {
            case 0:
                r = w.r(context, layoutInflater, chatMsg, view);
                break;
            case 1:
                r = t.o(context, layoutInflater, chatMsg, view);
                break;
            case 2:
                r = s.n(context, layoutInflater, chatMsg, view);
                break;
            case 8:
                r = d(context, layoutInflater, chatMsg, view);
                break;
            case 16:
                r = w.r(context, layoutInflater, a(context, chatMsg), view);
                break;
            case 10000:
                UnSupportedMsg unSupportedMsg = (UnSupportedMsg) chatMsg;
                TextMsg textMsg = new TextMsg();
                textMsg.setText(unSupportedMsg.getText());
                textMsg.setMsgTime(unSupportedMsg.getMsgTime());
                textMsg.setMsgId(unSupportedMsg.getMsgId());
                textMsg.setStatus(unSupportedMsg.getStatus());
                r = w.r(context, layoutInflater, textMsg, view);
                chatMsg = textMsg;
                break;
            default:
                TextMsg textMsg2 = new TextMsg();
                textMsg2.setText(context.getString(a.h.bd_im_text_unknow));
                textMsg2.setMsgTime(chatMsg.getMsgTime());
                textMsg2.setMsgId(chatMsg.getMsgId());
                textMsg2.setStatus(chatMsg.getStatus());
                r = w.r(context, layoutInflater, textMsg2, view);
                chatMsg = textMsg2;
                break;
        }
        if (r != null) {
            r.b(context, a(context, chatMsg));
            r.oNN = (ImageView) r.getConvertView().findViewById(a.f.bd_im_headview_vip);
        }
        return r;
    }

    private ChatMsg a(Context context, ChatMsg chatMsg) {
        if (chatMsg == null) {
            return null;
        }
        TextMsg textMsg = new TextMsg();
        if (chatMsg.getMsgType() == 16) {
            textMsg.setText(context.getString(a.h.bd_im_red_packet_default_text));
            textMsg.setMsgTime(chatMsg.getMsgTime());
            textMsg.setMsgId(chatMsg.getMsgId());
            textMsg.setStatus(chatMsg.getStatus());
            textMsg.setMsgType(0);
            return textMsg;
        }
        return chatMsg;
    }

    public d b(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        q l;
        switch (chatMsg.getMsgType()) {
            case 0:
                l = q.l(context, layoutInflater, chatMsg, view);
                break;
            case 1:
                l = n.i(context, layoutInflater, chatMsg, view);
                break;
            case 2:
                l = m.h(context, layoutInflater, chatMsg, view);
                break;
            case 8:
                l = c(context, layoutInflater, chatMsg, view);
                break;
            case 16:
                l = q.l(context, layoutInflater, a(context, chatMsg), view);
                break;
            case 18:
                l = q.l(context, layoutInflater, chatMsg, view);
                break;
            case 10000:
                UnSupportedMsg unSupportedMsg = (UnSupportedMsg) chatMsg;
                TextMsg textMsg = new TextMsg();
                textMsg.setText(unSupportedMsg.getText());
                textMsg.setMsgTime(unSupportedMsg.getMsgTime());
                textMsg.setMsgId(unSupportedMsg.getMsgId());
                l = q.l(context, layoutInflater, textMsg, view);
                chatMsg = textMsg;
                break;
            default:
                TextMsg textMsg2 = new TextMsg();
                textMsg2.setText(context.getString(a.h.bd_im_text_unknow));
                textMsg2.setMsgTime(chatMsg.getMsgTime());
                textMsg2.setMsgId(chatMsg.getMsgId());
                textMsg2.setStatus(chatMsg.getStatus());
                l = q.l(context, layoutInflater, textMsg2, view);
                chatMsg = textMsg2;
                break;
        }
        if (l != null) {
            l.b(context, a(context, chatMsg));
            l.oNN = (ImageView) l.getConvertView().findViewById(a.f.bd_im_headview_vip);
        }
        return l;
    }

    public c a(Context context, LayoutInflater layoutInflater, int i, ChatMsg chatMsg, View view, a aVar) {
        c cVar = null;
        switch (chatMsg.getMsgType()) {
            case 8:
                SignleGraphicTextMsg signleGraphicTextMsg = (SignleGraphicTextMsg) chatMsg;
                cVar = i.e(context, layoutInflater, chatMsg, view);
                break;
            case 9:
                cVar = j.f(context, layoutInflater, (MultiGraphicTextMsg) chatMsg, view);
                break;
            case 12:
                cVar = l.g(context, layoutInflater, (TempletMsg) chatMsg, view);
                break;
            case 21:
                cVar = k.a(context, layoutInflater, (SmartMsg) chatMsg, view, i, aVar);
                break;
        }
        if (cVar != null) {
            cVar.b(context, chatMsg);
        }
        return cVar;
    }

    public f a(Context context, LayoutInflater layoutInflater, View view, int i) {
        switch (i) {
            case 2010:
                return g.a(context, layoutInflater, view);
            default:
                return h.b(context, layoutInflater, view);
        }
    }

    private d c(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
        switch (r1.ekl()) {
            case VIDEOSHARE:
                return r.m(context, layoutInflater, chatMsg, view);
            case PRIVATEINVITE:
                return o.j(context, layoutInflater, chatMsg, view);
            default:
                return p.k(context, layoutInflater, chatMsg, view);
        }
    }

    private e d(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
        switch (r1.ekl()) {
            case VIDEOSHARE:
                return x.s(context, layoutInflater, chatMsg, view);
            case PRIVATEINVITE:
                return u.p(context, layoutInflater, chatMsg, view);
            default:
                return v.q(context, layoutInflater, chatMsg, view);
        }
    }
}
