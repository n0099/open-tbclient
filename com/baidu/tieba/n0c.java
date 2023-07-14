package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class n0c implements p0c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.p0c
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, d1c d1cVar, k1c k1cVar) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webSocket, d1cVar, k1cVar) == null) {
        }
    }

    @Override // com.baidu.tieba.p0c
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, d1c d1cVar) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webSocket, d1cVar) == null) {
        }
    }

    @Deprecated
    public abstract void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata);

    @Override // com.baidu.tieba.p0c
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webSocket, framedata) == null) {
        }
    }

    public n0c() {
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

    @Override // com.baidu.tieba.p0c
    public l1c onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, d1c d1cVar) throws InvalidDataException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webSocket, draft, d1cVar)) == null) {
            return new h1c();
        }
        return (l1c) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.p0c
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webSocket, framedata) == null) {
            webSocket.sendFrame(new b1c((a1c) framedata));
        }
    }
}
