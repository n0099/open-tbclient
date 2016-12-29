package com.baidu.tieba.onlineDebugger.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class j implements h {
    private String dSU;

    public void np(String str) {
        this.dSU = str;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aHc() {
        if (this.dSU == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(this.dSU).getInputStream()));
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

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aHd() {
        return false;
    }
}
