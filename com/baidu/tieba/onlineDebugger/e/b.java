package com.baidu.tieba.onlineDebugger.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.command.UploadCommand;
import com.baidu.tieba.onlineDebugger.command.c;
import com.baidu.tieba.onlineDebugger.command.d;
import com.baidu.tieba.onlineDebugger.command.e;
import com.baidu.tieba.onlineDebugger.command.f;
import com.baidu.tieba.onlineDebugger.command.g;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public class b {
    public static final d lE(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("get ")) {
            new com.baidu.tieba.onlineDebugger.b.a().ls(str);
            String trim = str.substring("get ".length()).trim();
            a aVar = new a();
            aVar.lz(trim);
            return new com.baidu.tieba.onlineDebugger.command.b(aVar.auG(), aVar.auH());
        } else if (str.startsWith("set ")) {
            new com.baidu.tieba.onlineDebugger.b.a().ls(str);
            String trim2 = str.substring("set ".length()).trim();
            a aVar2 = new a();
            aVar2.lz(trim2);
            return new com.baidu.tieba.onlineDebugger.command.b(aVar2.auG(), aVar2.auH());
        } else if (str.startsWith("exe ")) {
            new com.baidu.tieba.onlineDebugger.b.a().ls(str);
            String trim3 = str.substring("exe ".length()).trim();
            a aVar3 = new a();
            aVar3.lz(trim3);
            return new com.baidu.tieba.onlineDebugger.command.b(aVar3.auG(), aVar3.auH());
        } else if (str.startsWith("shell ")) {
            String substring = str.substring("shell ".length());
            if (substring.contains("su ")) {
                throw new RuntimeException("shell not support root cmd " + substring);
            }
            if (substring.contains("chmod")) {
                throw new RuntimeException("shell not support chmod cmd " + substring);
            }
            f fVar = new f();
            fVar.lt(substring);
            return fVar;
        } else {
            throw new RuntimeException("command has unknown start:" + str);
        }
    }

    public static final d a(com.baidu.tieba.onlineDebugger.d.a aVar) {
        UploadCommand.EnumUploadType enumUploadType;
        StringTokenizer stringTokenizer = new StringTokenizer(aVar.getMsgContent());
        int countTokens = stringTokenizer.countTokens();
        if (countTokens != 3 && countTokens != 2) {
            BdLog.e("Illegal upload command.");
            return null;
        }
        stringTokenizer.nextToken();
        String nextToken = stringTokenizer.nextToken();
        if (nextToken.equals("-anr")) {
            if (countTokens != 2) {
                BdLog.e("Illegal upload command.");
                return null;
            }
            return new UploadCommand(UploadCommand.EnumUploadType.ANR, "");
        } else if (countTokens != 3) {
            BdLog.e("Illegal upload command.");
            return null;
        } else {
            if (nextToken.equals("-s")) {
                enumUploadType = UploadCommand.EnumUploadType.SharePerference;
            } else if (nextToken.equals("-d")) {
                enumUploadType = UploadCommand.EnumUploadType.DB;
            } else if (nextToken.equals("-f")) {
                enumUploadType = UploadCommand.EnumUploadType.File;
            } else if (!nextToken.equals("-l")) {
                return null;
            } else {
                enumUploadType = UploadCommand.EnumUploadType.List;
            }
            return new UploadCommand(enumUploadType, stringTokenizer.nextToken());
        }
    }

    public static final d b(com.baidu.tieba.onlineDebugger.d.a aVar) {
        if (aVar == null) {
            return null;
        }
        switch (aVar.getMsgType()) {
            case 1:
                return new com.baidu.tieba.onlineDebugger.command.a();
            case 2:
                return new c();
            case 3:
                return lE(aVar.getMsgContent());
            case 4:
                return new g(aVar.getMsgContent());
            case 5:
                return a(aVar);
            case 6:
                return new e(aVar.getMsgContent());
            default:
                throw new RuntimeException("msg has unknown type " + aVar.getMsgType());
        }
    }
}
