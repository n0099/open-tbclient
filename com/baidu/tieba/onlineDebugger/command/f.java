package com.baidu.tieba.onlineDebugger.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class f implements d {
    private String dbz;

    public void lt(String str) {
        this.dbz = str;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public Object auA() {
        if (this.dbz == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(this.dbz).getInputStream()));
            StringBuffer stringBuffer = new StringBuffer(100);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                } else {
                    return stringBuffer.toString();
                }
            }
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public boolean auB() {
        return false;
    }
}
