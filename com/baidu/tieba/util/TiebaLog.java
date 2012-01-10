package com.baidu.tieba.util;

import com.baidu.tieba.data.Config;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
/* loaded from: classes.dex */
public class TiebaLog {
    public static final int ERROR_MAX_NUM = 10;
    public static final int ERROR_TYPE_DB = 3;
    public static final int ERROR_TYPE_IO = 2;
    public static final int ERROR_TYPE_LOGIC = 4;
    public static final int ERROR_TYPE_NET = 1;
    private static final boolean mlogSwitch = false;
    public static int error_net_num = 0;
    public static int error_io_num = 0;
    public static int error_db_num = 0;
    public static int error_logic_num = 0;

    public static int i(String className, String method, String msg) {
        return 0;
    }

    public static int e(String className, String method, String msg) {
        return 0;
    }

    public static int w(String className, String method, String msg) {
        return 0;
    }

    public static int v(String className, String method, String msg) {
        return 0;
    }

    public static int d(String className, String method, String msg) {
        return 0;
    }

    public static void log_e(int type, String className, String method, String msg) {
        FileWriter writer = null;
        boolean should_write_file = false;
        switch (type) {
            case 1:
                if (error_net_num < 10) {
                    should_write_file = true;
                    error_net_num++;
                    break;
                }
                break;
            case 2:
                if (error_io_num < 10) {
                    should_write_file = true;
                    error_io_num++;
                    break;
                }
                break;
            case 3:
                if (error_db_num < 10) {
                    should_write_file = true;
                    error_db_num++;
                    break;
                }
                break;
            case 4:
                if (error_logic_num < 10) {
                    should_write_file = true;
                    error_logic_num++;
                    break;
                }
                break;
        }
        if (should_write_file) {
            try {
                StringBuffer fullMsg = new StringBuffer(100);
                try {
                    fullMsg.append(new Date().getTime() / 1000);
                    fullMsg.append("\t");
                    fullMsg.append(type);
                    fullMsg.append("\t");
                    fullMsg.append(method);
                    if (msg != null) {
                        fullMsg.append(":");
                        fullMsg.append(msg.replace("\n", " ").replace("\t", " "));
                    }
                    fullMsg.append("\t");
                    fullMsg.append(className);
                    fullMsg.append("\t");
                    fullMsg.append(0);
                    fullMsg.append("\n");
                    String error = fullMsg.toString();
                    if (should_write_file) {
                        File file = FileHelper.CreateFileIfNotFound(Config.LOG_ERROR_FILE);
                        if (error != null && file != null && file.length() < Config.FATAL_ERROR_FILE_MAX_SIZE) {
                            FileWriter writer2 = new FileWriter(file, true);
                            try {
                                writer2.append((CharSequence) error);
                                writer2.flush();
                                writer = writer2;
                            } catch (Exception e) {
                                writer = writer2;
                                if (writer != null) {
                                    try {
                                        writer.close();
                                        return;
                                    } catch (Exception e2) {
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                writer = writer2;
                                if (writer != null) {
                                    try {
                                        writer.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e4) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception e6) {
            }
        }
    }
}
