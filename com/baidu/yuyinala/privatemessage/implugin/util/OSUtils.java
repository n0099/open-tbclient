package com.baidu.yuyinala.privatemessage.implugin.util;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Deprecated
/* loaded from: classes11.dex */
public class OSUtils {
    private static final ROM pgW = ems();

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [332=17, 334=16, 335=16, 336=16] */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ROM ems() {
        FileInputStream fileInputStream;
        Properties properties;
        ?? containsKey;
        ROM rom;
        char c = 0;
        ROM rom2 = ROM.Other;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                properties = new Properties();
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    properties.load(fileInputStream);
                    containsKey = properties.containsKey("ro.miui.ui.version.name");
                } catch (IOException e) {
                    e = e;
                }
                try {
                } catch (IOException e2) {
                    e = e2;
                    rom2 = containsKey;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return rom2;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        if (containsKey != 0 || properties.containsKey("ro.miui.ui.version.code")) {
            rom = ROM.MIUI;
            if (properties.containsKey("ro.miui.ui.version.name")) {
                String property = properties.getProperty("ro.miui.ui.version.name");
                if (!TextUtils.isEmpty(property) && property.matches("[Vv]\\d+")) {
                    try {
                        rom.setBaseVersion(Integer.parseInt(property.split("[Vv]")[1]));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            if (properties.containsKey(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL)) {
                String property2 = properties.getProperty(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
                if (!TextUtils.isEmpty(property2) && property2.matches("[\\d.]+")) {
                    rom.setVersion(property2);
                }
                rom2 = rom;
            }
            rom2 = rom;
        } else if (properties.containsKey("ro.build.version.emui") || properties.containsKey("ro.build.hw_emui_api_level") || properties.containsKey("ro.confg.hw_systemversion")) {
            rom = ROM.EMUI;
            if (properties.containsKey("ro.build.version.emui")) {
                String property3 = properties.getProperty("ro.build.version.emui");
                Matcher matcher = Pattern.compile("EmotionUI_([\\d.]+)").matcher(property3);
                if (!TextUtils.isEmpty(property3) && matcher.find()) {
                    try {
                        String group = matcher.group(1);
                        rom.setVersion(group);
                        rom.setBaseVersion(Integer.parseInt(group.split("\\.")[0]));
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                rom2 = rom;
            }
            rom2 = rom;
        } else if (properties.containsKey("ro.meizu.setupwizard.flyme") || properties.containsKey("ro.flyme.published")) {
            rom = ROM.Flyme;
            if (properties.containsKey(RomUtils.PROP_RO_BUILD_DISPLAY_ID)) {
                String property4 = properties.getProperty(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
                Matcher matcher2 = Pattern.compile("Flyme[^\\d]*([\\d.]+)[^\\d]*").matcher(property4);
                if (!TextUtils.isEmpty(property4) && matcher2.find()) {
                    try {
                        String group2 = matcher2.group(1);
                        rom.setVersion(group2);
                        rom.setBaseVersion(Integer.parseInt(group2.split("\\.")[0]));
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                rom2 = rom;
            }
            rom2 = rom;
        } else if (properties.containsKey("ro.oppo.theme.version") || properties.containsKey("ro.oppo.version") || properties.containsKey("ro.rom.different.version")) {
            rom = ROM.ColorOS;
            if (properties.containsKey("ro.rom.different.version")) {
                String property5 = properties.getProperty("ro.rom.different.version");
                Matcher matcher3 = Pattern.compile("ColorOS([\\d.]+)").matcher(property5);
                if (!TextUtils.isEmpty(property5) && matcher3.find()) {
                    try {
                        String group3 = matcher3.group(1);
                        rom.setVersion(group3);
                        rom.setBaseVersion(Integer.parseInt(group3.split("\\.")[0]));
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
                rom2 = rom;
            }
            rom2 = rom;
        } else if (properties.containsKey("ro.vivo.os.name") || properties.containsKey("ro.vivo.os.version") || properties.containsKey("ro.vivo.os.build.display.id")) {
            rom = ROM.FuntouchOS;
            if (properties.containsKey("ro.vivo.os.version")) {
                String property6 = properties.getProperty("ro.vivo.os.version");
                if (!TextUtils.isEmpty(property6) && property6.matches("[\\d.]+")) {
                    try {
                        rom.setVersion(property6);
                        rom.setBaseVersion(Integer.parseInt(property6.split("\\.")[0]));
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                rom2 = rom;
            }
            rom2 = rom;
        } else if (properties.containsKey("ro.letv.release.version") || properties.containsKey("ro.product.letv_name") || properties.containsKey("ro.product.letv_model")) {
            rom = ROM.EUI;
            if (properties.containsKey("ro.letv.release.version")) {
                String property7 = properties.getProperty("ro.letv.release.version");
                Matcher matcher4 = Pattern.compile("([\\d.]+)[^\\d]*").matcher(property7);
                if (!TextUtils.isEmpty(property7) && matcher4.find()) {
                    try {
                        String group4 = matcher4.group(1);
                        rom.setVersion(group4);
                        rom.setBaseVersion(Integer.parseInt(group4.split("\\.")[0]));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                rom2 = rom;
            }
            rom2 = rom;
        } else if (properties.containsKey("ro.gn.gnromvernumber") || properties.containsKey("ro.gn.amigo.systemui.support")) {
            rom = ROM.AmigoOS;
            if (properties.containsKey(RomUtils.PROP_RO_BUILD_DISPLAY_ID)) {
                String property8 = properties.getProperty(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
                Matcher matcher5 = Pattern.compile("amigo([\\d.]+)[a-zA-Z]*").matcher(property8);
                if (!TextUtils.isEmpty(property8) && matcher5.find()) {
                    try {
                        String group5 = matcher5.group(1);
                        rom.setVersion(group5);
                        rom.setBaseVersion(Integer.parseInt(group5.split("\\.")[0]));
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
                rom2 = rom;
            }
            rom2 = rom;
        } else if (properties.containsKey("ro.sony.irremote.protocol_type") || properties.containsKey("ro.sony.fota.encrypteddata")) {
            rom2 = ROM.Sony;
        } else if (properties.containsKey("ro.yulong.version.release") || properties.containsKey("ro.yulong.version.tag")) {
            rom2 = ROM.YuLong;
        } else if (properties.containsKey("htc.build.stage") || properties.containsKey("ro.htc.bluetooth.sap")) {
            rom2 = ROM.Sense;
        } else if (properties.containsKey("ro.lge.swversion") || properties.containsKey("ro.lge.swversion_short") || properties.containsKey("ro.lge.factoryversion")) {
            rom2 = ROM.LG;
        } else if (properties.containsKey("ro.lenovo.device") || properties.containsKey("ro.lenovo.platform") || properties.containsKey("ro.lenovo.adb")) {
            rom2 = ROM.Lenovo;
        } else if (properties.containsKey(RomUtils.PROP_RO_BUILD_DISPLAY_ID)) {
            String property9 = properties.getProperty(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
            if (!TextUtils.isEmpty(property9)) {
                if (property9.contains("Flyme")) {
                    rom2 = ROM.Flyme;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                } else if (property9.contains("amigo")) {
                    rom2 = ROM.AmigoOS;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                }
                return rom2;
            }
        } else if (properties.containsKey("ro.build.version.base_os")) {
            String property10 = properties.getProperty("ro.build.version.base_os");
            if (!TextUtils.isEmpty(property10)) {
                if (property10.contains(RomUtils.ROM_OPPO)) {
                    rom2 = ROM.ColorOS;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    }
                } else if (property10.contains("samsung")) {
                    rom2 = ROM.SamSung;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
                return rom2;
            }
        } else if (properties.containsKey("ro.com.google.clientidbase")) {
            String property11 = properties.getProperty("ro.com.google.clientidbase");
            switch (property11.hashCode()) {
                case -1297558593:
                    if (property11.equals("android-gionee")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1158135215:
                    if (property11.equals("android-lenovo")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1037975490:
                    if (property11.equals("android-oppo")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1037773494:
                    if (property11.equals("android-vivo")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -811278887:
                    if (property11.equals("android-xiaomi")) {
                        break;
                    }
                    c = 65535;
                    break;
                case -652932276:
                    if (property11.equals("android-coolpad")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -380192433:
                    if (property11.equals("android-htc-rev")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -64814069:
                    if (property11.equals("android-sonyericsson")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 259783324:
                    if (property11.equals("android-samsung")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    rom2 = ROM.MIUI;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 1:
                    rom2 = ROM.ColorOS;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 2:
                    rom2 = ROM.FuntouchOS;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 3:
                    rom2 = ROM.SamSung;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e20) {
                            e20.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 4:
                    rom2 = ROM.Sony;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e21) {
                            e21.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 5:
                    rom2 = ROM.YuLong;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e22) {
                            e22.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 6:
                    rom2 = ROM.Sense;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e23) {
                            e23.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 7:
                    rom2 = ROM.Lenovo;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e24) {
                            e24.printStackTrace();
                            break;
                        }
                    }
                    break;
                case '\b':
                    rom2 = ROM.AmigoOS;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e25) {
                            e25.printStackTrace();
                            break;
                        }
                    }
                    break;
            }
            return rom2;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        }
        return rom2;
    }

    /* loaded from: classes11.dex */
    public enum ROM {
        MIUI,
        Flyme,
        EMUI,
        ColorOS,
        FuntouchOS,
        SmartisanOS,
        EUI,
        Sense,
        AmigoOS,
        _360OS,
        NubiaUI,
        H2OS,
        YunOS,
        YuLong,
        SamSung,
        Sony,
        Lenovo,
        LG,
        Google,
        Other;
        
        private int baseVersion = -1;
        private String version;

        ROM() {
        }

        void setVersion(String str) {
            this.version = str;
        }

        void setBaseVersion(int i) {
            this.baseVersion = i;
        }

        public int getBaseVersion() {
            return this.baseVersion;
        }

        public String getVersion() {
            return this.version;
        }
    }
}
