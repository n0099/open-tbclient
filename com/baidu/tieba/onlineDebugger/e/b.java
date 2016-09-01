package com.baidu.tieba.onlineDebugger.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.command.UploadCommand;
import com.baidu.tieba.onlineDebugger.command.f;
import com.baidu.tieba.onlineDebugger.command.g;
import com.baidu.tieba.onlineDebugger.command.h;
import com.baidu.tieba.onlineDebugger.command.i;
import com.baidu.tieba.onlineDebugger.command.j;
import com.baidu.tieba.onlineDebugger.command.k;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public class b {
    public static final h oA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("get ")) {
            new com.baidu.tieba.onlineDebugger.b.a().om(str);
            String trim = str.substring("get ".length()).trim();
            a aVar = new a();
            aVar.ov(trim);
            return new f(aVar.aKN(), aVar.aKO());
        } else if (str.startsWith("set ")) {
            new com.baidu.tieba.onlineDebugger.b.a().om(str);
            String trim2 = str.substring("set ".length()).trim();
            a aVar2 = new a();
            aVar2.ov(trim2);
            return new f(aVar2.aKN(), aVar2.aKO());
        } else if (str.startsWith("exe ")) {
            new com.baidu.tieba.onlineDebugger.b.a().om(str);
            String trim3 = str.substring("exe ".length()).trim();
            a aVar3 = new a();
            aVar3.ov(trim3);
            return new f(aVar3.aKN(), aVar3.aKO());
        } else if (str.startsWith("shell ")) {
            String substring = str.substring("shell ".length());
            if (substring.contains("su ")) {
                throw new RuntimeException("shell not support root cmd " + substring);
            }
            if (substring.contains("chmod")) {
                throw new RuntimeException("shell not support chmod cmd " + substring);
            }
            j jVar = new j();
            jVar.on(substring);
            return jVar;
        } else {
            throw new RuntimeException("command has unknown start:" + str);
        }
    }

    public static final h a(com.baidu.tieba.onlineDebugger.d.a aVar) {
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
            } else if (nextToken.equals("-l")) {
                enumUploadType = UploadCommand.EnumUploadType.List;
            } else if (nextToken.equals("-fdata")) {
                enumUploadType = UploadCommand.EnumUploadType.DataFile;
            } else if (!nextToken.equals("-ldata")) {
                return null;
            } else {
                enumUploadType = UploadCommand.EnumUploadType.DataList;
            }
            return new UploadCommand(enumUploadType, stringTokenizer.nextToken());
        }
    }

    public static final h b(com.baidu.tieba.onlineDebugger.d.a aVar) {
        if (aVar == null) {
            return null;
        }
        switch (aVar.getMsgType()) {
            case 1:
                return new com.baidu.tieba.onlineDebugger.command.a();
            case 2:
                return new g();
            case 3:
                return oA(aVar.getMsgContent());
            case 4:
                return new k(aVar.getMsgContent());
            case 5:
                return a(aVar);
            case 6:
                return new i(aVar.getMsgContent());
            case 7:
                return new com.baidu.tieba.onlineDebugger.command.b(aVar.getMsgContent());
            default:
                throw new RuntimeException("msg has unknown type " + aVar.getMsgType());
        }
    }
}
