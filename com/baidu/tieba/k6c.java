package com.baidu.tieba;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes6.dex */
public interface k6c {
    InetSocketAddress getLocalSocketAddress(WebSocket webSocket);

    InetSocketAddress getRemoteSocketAddress(WebSocket webSocket);

    void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z);

    void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str);

    void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z);

    void onWebsocketError(WebSocket webSocket, Exception exc);

    void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, y6c y6cVar, f7c f7cVar) throws InvalidDataException;

    g7c onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, y6c y6cVar) throws InvalidDataException;

    void onWebsocketHandshakeSentAsClient(WebSocket webSocket, y6c y6cVar) throws InvalidDataException;

    void onWebsocketMessage(WebSocket webSocket, String str);

    void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer);

    void onWebsocketOpen(WebSocket webSocket, d7c d7cVar);

    void onWebsocketPing(WebSocket webSocket, Framedata framedata);

    void onWebsocketPong(WebSocket webSocket, Framedata framedata);

    void onWriteDemand(WebSocket webSocket);
}
