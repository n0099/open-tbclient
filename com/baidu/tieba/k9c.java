package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.java_websocket.WebSocket;
/* loaded from: classes6.dex */
public abstract class k9c extends l9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int connectionLostTimeout;
    public Timer connectionLostTimer;
    public TimerTask connectionLostTimerTask;
    public boolean reuseAddr;
    public boolean tcpNoDelay;
    public boolean websocketRunning;

    public abstract Collection<WebSocket> getConnections();

    /* loaded from: classes6.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<WebSocket> a;
        public final /* synthetic */ k9c b;

        public a(k9c k9cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k9cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k9cVar;
            this.a = new ArrayList<>();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.clear();
                try {
                    this.a.addAll(this.b.getConnections());
                    long currentTimeMillis = System.currentTimeMillis() - (this.b.connectionLostTimeout * 1500);
                    Iterator<WebSocket> it = this.a.iterator();
                    while (it.hasNext()) {
                        WebSocket next = it.next();
                        if (next instanceof m9c) {
                            m9c m9cVar = (m9c) next;
                            if (m9cVar.r() < currentTimeMillis) {
                                if (m9c.u) {
                                    PrintStream printStream = System.out;
                                    printStream.println("Closing connection due to no pong received: " + next.toString());
                                }
                                m9cVar.f(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
                            } else if (m9cVar.B()) {
                                m9cVar.J();
                            } else if (m9c.u) {
                                PrintStream printStream2 = System.out;
                                printStream2.println("Trying to ping a non open connection: " + next.toString());
                            }
                        }
                    }
                } catch (Exception e) {
                    if (m9c.u) {
                        PrintStream printStream3 = System.out;
                        printStream3.println("Exception during connection lost ping: " + e.getMessage());
                    }
                }
                this.a.clear();
            }
        }
    }

    public k9c() {
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
        this.connectionLostTimeout = 60;
        this.websocketRunning = false;
    }

    private void cancelConnectionLostTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Timer timer = this.connectionLostTimer;
            if (timer != null) {
                timer.cancel();
                this.connectionLostTimer = null;
            }
            TimerTask timerTask = this.connectionLostTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.connectionLostTimerTask = null;
            }
        }
    }

    private void restartConnectionLostTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            cancelConnectionLostTimer();
            this.connectionLostTimer = new Timer("WebSocketTimer");
            a aVar = new a(this);
            this.connectionLostTimerTask = aVar;
            Timer timer = this.connectionLostTimer;
            int i = this.connectionLostTimeout;
            timer.scheduleAtFixedRate(aVar, i * 1000, i * 1000);
        }
    }

    public int getConnectionLostTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.connectionLostTimeout;
        }
        return invokeV.intValue;
    }

    public boolean isReuseAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.reuseAddr;
        }
        return invokeV.booleanValue;
    }

    public boolean isTcpNoDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.tcpNoDelay;
        }
        return invokeV.booleanValue;
    }

    public void startConnectionLostTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.connectionLostTimeout <= 0) {
                if (m9c.u) {
                    System.out.println("Connection lost timer deactivated");
                    return;
                }
                return;
            }
            if (m9c.u) {
                System.out.println("Connection lost timer started");
            }
            this.websocketRunning = true;
            restartConnectionLostTimer();
        }
    }

    public void stopConnectionLostTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.connectionLostTimer != null || this.connectionLostTimerTask != null) {
                this.websocketRunning = false;
                if (m9c.u) {
                    System.out.println("Connection lost timer stopped");
                }
                cancelConnectionLostTimer();
            }
        }
    }

    public void setReuseAddr(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.reuseAddr = z;
        }
    }

    public void setTcpNoDelay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.tcpNoDelay = z;
        }
    }

    public void setConnectionLostTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.connectionLostTimeout = i;
            if (i <= 0) {
                if (m9c.u) {
                    System.out.println("Connection lost timer stopped");
                }
                cancelConnectionLostTimer();
            } else if (this.websocketRunning) {
                if (m9c.u) {
                    System.out.println("Connection lost timer restarted");
                }
                try {
                    Iterator it = new ArrayList(getConnections()).iterator();
                    while (it.hasNext()) {
                        WebSocket webSocket = (WebSocket) it.next();
                        if (webSocket instanceof m9c) {
                            ((m9c) webSocket).N();
                        }
                    }
                } catch (Exception e) {
                    if (m9c.u) {
                        PrintStream printStream = System.out;
                        printStream.println("Exception during connection lost restart: " + e.getMessage());
                    }
                }
                restartConnectionLostTimer();
            }
        }
    }
}
