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
/* loaded from: classes4.dex */
public abstract class lu9 implements nu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public lu9() {
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

    @Override // com.baidu.tieba.nu9
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, bv9 bv9Var, iv9 iv9Var) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webSocket, bv9Var, iv9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nu9
    public jv9 onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, bv9 bv9Var) throws InvalidDataException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webSocket, draft, bv9Var)) == null) ? new fv9() : (jv9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.nu9
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, bv9 bv9Var) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webSocket, bv9Var) == null) {
        }
    }

    @Deprecated
    public abstract void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata);

    @Override // com.baidu.tieba.nu9
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webSocket, framedata) == null) {
            webSocket.sendFrame(new zu9((yu9) framedata));
        }
    }

    @Override // com.baidu.tieba.nu9
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webSocket, framedata) == null) {
        }
    }
}
