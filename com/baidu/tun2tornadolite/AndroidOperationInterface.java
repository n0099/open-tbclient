package com.baidu.tun2tornadolite;

import java.net.DatagramSocket;
import java.net.Socket;
import kotlin.Metadata;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0011H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/baidu/tun2tornadolite/AndroidOperationInterface;", "", "bindNetwork", "", "networkType", "fd", "getNetwork", "", "getPing", "onEvent", "", "msgType", "msgText", "protect", "", "socket", "Ljava/net/DatagramSocket;", "Ljava/net/Socket;", "", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface AndroidOperationInterface {
    long bindNetwork(long j2, long j3);

    String getNetwork(long j2);

    String getPing();

    void onEvent(long j2, String str);

    boolean protect(int i2);

    boolean protect(DatagramSocket datagramSocket);

    boolean protect(Socket socket);
}
